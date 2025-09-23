import java.util.PriorityQueue;

public class Problem313 {
    public static void main(String[] args) {
        // Example usage
        int n = 12;
        int[] primes = { 2, 7, 13, 19 };
        Solution solution = new Solution();
        System.out.println(solution.nthSuperUglyNumber(n, primes)); // Output: 32
    }
}

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(1);
        int x = 0;
        while (n-- > 0) {
            x = q.poll();
            while (!q.isEmpty() && q.peek() == x) {
                q.poll();
            }
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) {
                    q.offer(k * x);
                }
                if (x % k == 0) {
                    break;
                }
            }
        }
        return x;
    }
}