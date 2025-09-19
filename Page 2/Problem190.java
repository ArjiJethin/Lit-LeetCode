
public class Problem190 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 43261596; // Example input
        int result = solution.reverseBits(n);
        System.out.println(result); // Output: 964176192
    }
}

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            res |= ((n & 1) << (31 - i));
            n >>>= 1;
        }
        return res;
    }
}