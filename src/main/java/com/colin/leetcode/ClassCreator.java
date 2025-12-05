package com.colin.leetcode;


import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ClassCreator {

    public static void createNewProblemFile(String name) {
        try {
            String outputFilePath = "src/test/java/com/colin/leetcode/" + name + ".java";
            URL url = ClassCreator.class.getResource("/class-template.txt");
            RandomAccessFile templateFile = new RandomAccessFile(url.getFile(), "r");
            FileChannel inChannel = templateFile.getChannel();

            ByteBuffer buffIn = ByteBuffer.allocate(1024);
            StringBuilder buffer = new StringBuilder();

            while (inChannel.read(buffIn) != -1) {
                buffIn.flip();
                buffer.append(new String(buffIn.array()));
                buffIn.clear();
            }

            String fileContent = buffer.toString().replace("CLASS_NAME", name).trim();
            ByteBuffer buffOut = ByteBuffer.wrap(fileContent.getBytes("utf-8"));

            RandomAccessFile outputFile = new RandomAccessFile(outputFilePath, "rw");
            if (outputFile.length() > 0) {
                System.out.println("File already exist. Exit...");
                return;
            }
            FileChannel outChannel = outputFile.getChannel();
            outChannel.write(buffOut);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int index;
        String original;
        Scanner scanner;

        // 检查是否有命令行参数
        if (args.length >= 2) {
            // 使用命令行参数
            try {
                index = Integer.parseInt(args[0]);
                original = args[1];
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid problem number format.");
                printUsage();
                return;
            }
        } else {
            // 回退到控制台输入
            scanner = new Scanner(System.in);
            
            System.out.println("Input Number:");
            index = scanner.nextInt();

            System.out.println("Input Name:");
            original = scanner.next();
        }

        String elems[] = original.split(Pattern.quote("-"));

        StringBuilder name = new StringBuilder("S" + NameFormatter.getLengthString(String.valueOf(index), 4));

        for (String elem : elems) {
            name.append("_");
            name.append(NameFormatter.captureName(elem));
        }

        ClassCreator.createNewProblemFile(name.toString());
    }
    
    /**
     * 打印使用说明
     */
    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("1. Command line: java ClassCreator <problem_number> <problem_name>");
        System.out.println("   Example: java ClassCreator 1 two-sum");
        System.out.println("2. Console input: Run without arguments and follow prompts");
    }
}