public class Problem390 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 9; // Example input
        int result = solution.lastRemaining(n);
        System.out.println("The last remaining number is: " + result);
    }
}

class Solution {
    public int lastRemaining(int n) {
        int a1 = 1, step = 1;
        for (int i = 0, cnt = n; cnt > 1; cnt >>= 1, step <<= 1, ++i) {
            if (i % 2 == 1) {
                if (cnt % 2 == 1) {
                    a1 += step;
                }
            } else {
                a1 += step;
            }
        }
        return a1;
    }
}