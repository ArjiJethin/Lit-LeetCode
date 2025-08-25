public class Problem434 {
    public static void main(String[] args) {
        // Example usage
        String s = "Hello, my name is John";
        Solution solution = new Solution();
        int count = solution.countSegments(s);
        System.out.println("Number of segments: " + count);
    }
}

class Solution {
    public int countSegments(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                ++ans;
            }
        }
        return ans;
    }
}