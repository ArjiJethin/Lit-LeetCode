public class Problem463 {
    public static void main(String[] args) {
        // Example usage
        int[][] grid = {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 0 }
        };
        Solution solution = new Solution();
        int result = solution.islandPerimeter(grid);
        System.out.println("Island perimeter: " + result); // Expected output: 16
    }
}

class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans += 4;
                    if (i < m - 1 && grid[i + 1][j] == 1) {
                        ans -= 2;
                    }
                    if (j < n - 1 && grid[i][j + 1] == 1) {
                        ans -= 2;
                    }
                }
            }
        }
        return ans;
    }
}