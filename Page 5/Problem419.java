public class Problem419 {
    public static void main(String[] args) {
        // Example usage
        char[][] board = {
                { 'X', '.', '.', 'X' },
                { '.', '.', '.', 'X' },
                { '.', 'X', 'X', '.' }
        };
        Solution solution = new Solution();
        int result = solution.countBattleships(board);
        System.out.println(result); // Expected output: 3
    }
}

class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                ++ans;
            }
        }
        return ans;
    }
}