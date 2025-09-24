public class Problem319 {
    public static void main(String[] args) {
        // Example usage
        int n = 10;
        Solution solution = new Solution();
        System.out.println(solution.bulbSwitch(n)); // Output: 3
    }
}

class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}