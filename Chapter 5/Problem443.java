public class Problem443 {
    public static void main(String[] args) {
        // Example usage
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        Solution solution = new Solution();
        int length = solution.compress(chars);
        System.out.println("Compressed length: " + length); // Expected output: 6
        System.out.println("Compressed chars: " + new String(chars, 0, length)); // Expected output: "a2b2c3"
    }
}

class Solution {
    public int compress(char[] chars) {
        int k = 0, n = chars.length;
        for (int i = 0, j = i + 1; i < n;) {
            while (j < n && chars[j] == chars[i]) {
                ++j;
            }
            chars[k++] = chars[i];
            if (j - i > 1) {
                String cnt = String.valueOf(j - i);
                for (char c : cnt.toCharArray()) {
                    chars[k++] = c;
                }
            }
            i = j;
        }
        return k;
    }
}