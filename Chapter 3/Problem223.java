public class Problem223 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage:
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4;
        int bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        System.out.println(solution.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)); // Output: 45
    }
}

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a = (ax2 - ax1) * (ay2 - ay1);
        int b = (bx2 - bx1) * (by2 - by1);
        int width = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int height = Math.min(ay2, by2) - Math.max(ay1, by1);
        return a + b - Math.max(height, 0) * Math.max(width, 0);
    }
}