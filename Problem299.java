public class Problem299 {
    public static void main(String[] args) {
        // Example usage
        String secret = "1807";
        String guess = "7810";
        Solution solution = new Solution();
        String result = solution.getHint(secret, guess);
        System.out.println(result); // Expected output: "1A3B"
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        int x = 0, y = 0;
        int[] cnt1 = new int[10];
        int[] cnt2 = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            int a = secret.charAt(i) - '0', b = guess.charAt(i) - '0';
            if (a == b) {
                ++x;
            } else {
                ++cnt1[a];
                ++cnt2[b];
            }
        }
        for (int i = 0; i < 10; ++i) {
            y += Math.min(cnt1[i], cnt2[i]);
        }
        return String.format("%dA%dB", x, y);
    }
}