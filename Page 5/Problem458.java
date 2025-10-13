public class Problem458 {
    public static void main(String[] args) {
        // Example usage
        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 60;
        Solution solution = new Solution();
        int result = solution.poorPigs(buckets, minutesToDie, minutesToTest);
        System.out.println("Minimum number of pigs needed: " + result); // Expected output: 5
    }
}

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base = minutesToTest / minutesToDie + 1;
        int res = 0;
        for (int p = 1; p < buckets; p *= base) {
            ++res;
        }
        return res;
    }
}