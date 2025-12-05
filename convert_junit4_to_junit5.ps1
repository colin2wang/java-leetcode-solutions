# 定义测试文件目录
$testDir = "F:\Workspaces\JetBrains\IdeaProjects\java-leetcode-solutions\src\test\java\com\colin\leetcode"

# 获取所有Java测试文件
$testFiles = Get-ChildItem -Path $testDir -Filter "*.java" -File

# 遍历所有测试文件
foreach ($file in $testFiles) {
    Write-Host "Processing file: $($file.Name)"
    
    # 读取文件内容
    $content = Get-Content -Path $file.FullName -Raw
    
    # 替换JUnit 4的@Test注解为JUnit 5的@Test注解
    $content = $content -replace "import org.junit.Test;", "import org.junit.jupiter.api.Test;"
    
    # 替换JUnit 4的Assert为JUnit 5的Assertions
    $content = $content -replace "import org.junit.Assert;", "import org.junit.jupiter.api.Assertions;"
    $content = $content -replace "Assert\.", "Assertions."
    
    # 写入更新后的内容
    Set-Content -Path $file.FullName -Value $content
}

Write-Host "All test files have been converted from JUnit 4 to JUnit 5!"