import java.util.Arrays;

public class Problem204 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10)); // Output: 4
        System.out.println(solution.countPrimes(20)); // Output: 8
    }
}

class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (primes[i]) {
                ++ans;
                for (int j = i + i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        return ans;
    }
}