public class Problem240 {
    public static void main(String[] args) {
        // Example usage
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 },
                { 61, 66, 67, 70 }
        };
        int target = 3;
        Solution solution = new Solution();
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Target found: " + result); // Should print true
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                --i;
            } else {
                ++j;
            }
        }
        return false;
    }
}