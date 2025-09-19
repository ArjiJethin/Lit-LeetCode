
public class Problem191 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 11; // Example input
        int result = solution.hammingWeight(n);
        System.out.println(result); // Output: 3
    }
}

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n &= n - 1;
            ++ans;
        }
        return ans;
    }
}