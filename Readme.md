# LeetCode Solutions

This repository contains Java solutions to LeetCode problems. Each solution is accompanied by unit tests to verify correctness.

## Project Structure

- **Solutions**: All problem solutions are located in the test directory following a consistent naming pattern.
  - [src/test/java/com/colin/leetcode](src/test/java/com/colin/leetcode)
- **Utilities**: Helper classes for managing the project structure and creating new problem files.
  - [src/main/java/com/colin/leetcode](src/main/java/com/colin/leetcode)
- **Templates**: Contains templates for creating new problem files.
  - [src/main/resources/class-template.txt](src/main/resources/class-template.txt)

## Features

- **Consistent Structure**: Each problem solution follows the same class structure with embedded test cases.
- **Problem Creator**: Utilities to automatically generate new problem files with the correct naming format (both Java and PowerShell versions available).
- **Unit Tests**: All solutions include JUnit tests to validate the implementations.
- **Test Converter**: PowerShell script to convert JUnit 4 tests to JUnit 5.

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven

### Building the Project

```bash
mvn clean install
```

### Running Tests

```bash
mvn test
```

## Creating a New Problem Solution

The project provides two utilities to create new problem files with the correct naming convention:

### Option 1: Java ClassCreator

1. Run the `ClassCreator` class
2. Enter the LeetCode problem number when prompted
3. Enter the problem name (using kebab-case)

Example:

```
Input Number:
0001
Input Name:
two-sum
```

This will create a new file named `S0001_Two_Sum.java` in the test directory.

### Option 2: PowerShell Script

The project also includes a PowerShell script `create_leetcode_class.ps1` for Windows users, which provides the same functionality with command line support.

#### Using Command Line Parameters

```powershell
.\create_leetcode_class.ps1 1 two-sum
```

#### Using Console Input

```powershell
.\create_leetcode_class.ps1
```

Then follow the prompts to enter the problem number and name.

#### Viewing Help

```powershell
.\create_leetcode_class.ps1 -Help
```

## PowerShell Scripts

### 1. JUnit 4 to JUnit 5 Converter

The `convert_junit4_to_junit5.ps1` script automatically converts all JUnit 4 test files to JUnit 5 format. This includes:
- Updating import statements
- Converting `@Test` annotations
- Replacing assertion methods

**Usage:**

```powershell
.\convert_junit4_to_junit5.ps1
```

### 2. LeetCode Class Creator

The `create_leetcode_class.ps1` script generates new LeetCode problem files with the correct naming convention:
- Converts problem numbers to 4-digit format
- Transforms kebab-case names to PascalCase
- Creates files with the appropriate template

**Features:**
- Supports both command line parameters and console input
- Validates input parameters
- Checks if the file already exists
- Creates files with proper structure

**Usage:**

```powershell
# With command line parameters
.\create_leetcode_class.ps1 <problem_number> <problem_name>

# Example
.\create_leetcode_class.ps1 1 two-sum

# With console input
.\create_leetcode_class.ps1
```

## Solution Format

Each solution follows this format:

```java
public class SXXXX_Problem_Name {

    class Solution {
        // Solution code here
    }

    @Test
    public void test() {
        // Test cases here
    }
}
```

## Example Solution

Here's an example of the Two Sum solution:

```java
public class S0001_Two_Sum {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int remainder = target - nums[i];
                if(map.containsKey(nums[i]))
                    return new int[]{map.get(nums[i]), i};
                map.put(remainder, i);
            }
            throw new IllegalArgumentException("no solution.");
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int nums[] = {2,7,11,15};
        int expecteds[] = {0,1};
        Assert.assertArrayEquals(expecteds, solution.twoSum(nums, 9));
    }
}
```

## Contributing

Feel free to contribute by adding new solutions or improving existing ones. Make sure to follow the project's code style and include test cases for any new solutions.