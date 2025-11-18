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
- **Problem Creator**: A utility to automatically generate new problem files with the correct naming format.
- **Unit Tests**: All solutions include JUnit tests to validate the implementations.

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

The project includes a utility to create new problem files with the correct naming convention. Follow these steps:

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