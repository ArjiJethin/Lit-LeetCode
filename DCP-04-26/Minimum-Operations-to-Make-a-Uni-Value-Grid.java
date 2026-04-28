1class Solution {
2
3    public int minOperations(int[][] grid, int x) {
4        // Create a list to store all the numbers from the grid
5        ArrayList<Integer> numsArray = new ArrayList<>();
6        int result = 0;
7
8        // Flatten the grid into numsArray
9        for (int row = 0; row < grid.length; row++) {
10            for (int col = 0; col < grid[0].length; col++) {
11                numsArray.add(grid[row][col]);
12            }
13        }
14
15        // Sort numsArray in non-decreasing order to easily find the median
16        Collections.sort(numsArray);
17
18        int length = numsArray.size();
19        // Store the median element as the final common value
20        int finalCommonNumber = numsArray.get(length / 2);
21
22        // Iterate through each number in numsArray
23        for (int number : numsArray) {
24            // If the remainder when divided by x is different, return -1
25            if (number % x != finalCommonNumber % x) {
26                return -1;
27            }
28            // Add the number of operations required to make the current number equal to finalCommonNumber
29            result += Math.abs(finalCommonNumber - number) / x;
30        }
31
32        return result;
33    }
34}