<#
.SYNOPSIS
Create LeetCode problem Java test file

.DESCRIPTION
Create a Java test file with the correct naming convention based on LeetCode problem number and name

.PARAMETER Number
LeetCode problem number

.PARAMETER Name
LeetCode problem name (in kebab-case format, e.g., two-sum)

.EXAMPLE
PS> .\create_leetcode_class.ps1 1 two-sum
Creates file: S0001_Two_Sum.java

.EXAMPLE
PS> .\create_leetcode_class.ps1
Input Number:
1
Input Name:
two-sum
Creates file: S0001_Two_Sum.java
#>

param(
    [Parameter(Mandatory=$false, Position=0)]
    [string]$Number,
    
    [Parameter(Mandatory=$false, Position=1)]
    [string]$Name
)

# Define template file path
$templatePath = Join-Path -Path $PSScriptRoot -ChildPath "src\main\resources\class-template.txt"

# If no command line arguments provided, use console input
if (-not $Number -or -not $Name) {
    $Number = Read-Host "Input Number"
    $Name = Read-Host "Input Name"
}

# Validate input
if (-not $Number -or -not $Name) {
    Write-Host "Error: Problem number and name cannot be empty" -ForegroundColor Red
    exit 1
}

# Validate problem number is numeric
if (-not [int]::TryParse($Number, [ref]$null)) {
    Write-Host "Error: Problem number must be a numeric value" -ForegroundColor Red
    exit 1
}

# Format problem number to 4 digits
$formattedNumber = "{0:D4}" -f [int]$Number

# Convert problem name from kebab-case to PascalCase
$nameParts = $Name.Split("-")
$formattedNameParts = @()

foreach ($part in $nameParts) {
    if ($part) {
        $formattedNameParts += $part.Substring(0, 1).ToUpper() + $part.Substring(1).ToLower()
    }
}

$formattedName = $formattedNameParts -join "_"

# Generate full class name
$className = "S${formattedNumber}_${formattedName}"

# Generate output file path
$outputPath = Join-Path -Path $PSScriptRoot -ChildPath "src\test\java\com\colin\leetcode\${className}.java"

# Check if file already exists
if (Test-Path -Path $outputPath) {
    Write-Host "File already exists: $outputPath" -ForegroundColor Yellow
    exit 1
}

# Check if template file exists
if (-not (Test-Path -Path $templatePath)) {
    Write-Host "Error: Template file not found: $templatePath" -ForegroundColor Red
    exit 1
}

# Read template file content
$templateContent = Get-Content -Path $templatePath -Raw

# Replace class name in template
$fileContent = $templateContent -replace "CLASS_NAME", $className

# Write new file
try {
    # Explicitly use UTF-8 without BOM
    [System.IO.File]::WriteAllText($outputPath, $fileContent, [System.Text.UTF8Encoding]::new($false))
    Write-Host "Successfully created file: $outputPath" -ForegroundColor Green
} catch {
    Write-Host "Error: Failed to create file: $_" -ForegroundColor Red
    exit 1
}