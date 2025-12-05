package com.colin.leetcode;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class S1116_Print_Zero_Even_Odd {

//    class ZeroEvenOdd {
//        private int n;
//        private volatile int current = 1;
//        private Semaphore zero = new Semaphore(1);
//        private Semaphore even = new Semaphore(0);
//        private Semaphore odd = new Semaphore(0);
//
//        public ZeroEvenOdd(int n) {
//            this.n = n;
//        }
//
//        // printNumber.accept(x) outputs "x", where x is an integer.
//        public void zero(IntConsumer printNumber) throws InterruptedException {
//            while (true) {
//                zero.acquire(1);
//                if (current > n) {
//                    break;
//                }
//                printNumber.accept(0);
//                switch (current % 2) {
//                    case 0:
//                        odd.release(1);
//                        break;
//                    case 1:
//                        even.release(1);
//                        break;
//                }
//            }
//        }
//
//        public void even(IntConsumer printNumber) throws InterruptedException {
//            while (true) {
//                even.acquire(1);
//                if (current > n) {
//                    break;
//                }
//                printNumber.accept(current);
//                current++;
//                zero.release(1);
//            }
//        }
//
//        public void odd(IntConsumer printNumber) throws InterruptedException {
//            while (true) {
//                odd.acquire(1);
//                if (current > n) {
//                    break;
//                }
//                printNumber.accept(current);
//                current++;
//                zero.release(1);
//            }
//        }
//    }

    class ZeroEvenOdd {
        private int n;
        private Semaphore zero = new Semaphore(1);
        private Semaphore even = new Semaphore(0);
        private Semaphore odd = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for(int i = 0; i < n; i++){
                zero.acquire(1);
                printNumber.accept(0);
                if(i % 2 == 0){
                    odd.release(1);
                } else{
                    even.release(1);
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for(int i = 2;i <= n;i += 2){
                even.acquire(1);
                printNumber.accept(i);
                zero.release(1);
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for(int i = 1;i <= n;i += 2){
                odd.acquire(1);
                printNumber.accept(i);
                zero.release(1);
            }
        }
    }

    @Test
    public void test() {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.print(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.print(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.print(value);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
