public class Problem440 {
    public static void main(String[] args) {
        // Example usage
        int n = 13, k = 2;
        Solution solution = new Solution();
        int result = solution.findKthNumber(n, k);
        System.out.println("The " + k + "th number in lexicographical order is: " + result); // Expected output: 10
    }
}

class Solution {
    private int n;

    public int findKthNumber(int n, int k) {
        this.n = n;
        long curr = 1;
        --k;
        while (k > 0) {
            int cnt = count(curr);
            if (k >= cnt) {
                k -= cnt;
                ++curr;
            } else {
                --k;
                curr *= 10;
            }
        }
        return (int) curr;
    }

    public int count(long curr) {
        long next = curr + 1;
        long cnt = 0;
        while (curr <= n) {
            cnt += Math.min(n - curr + 1, next - curr);
            next *= 10;
            curr *= 10;
        }
        return (int) cnt;
    }
}