public class Problem202 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(19)); // Output: true
        System.out.println(solution.isHappy(2)); // Output: false
    }
}

class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = next(n);
        while (slow != fast) {
            slow = next(slow);
            fast = next(next(fast));
        }
        return slow == 1;
    }

    private int next(int x) {
        int y = 0;
        for (; x > 0; x /= 10) {
            y += (x % 10) * (x % 10);
        }
        return y;
    }
}