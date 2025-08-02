public class Problem482 {
    public static void main(String[] args) {
        // Example usage
        String s = "5F3Z-2e-9-w";
        int k = 4;
        Solution solution = new Solution();
        String result = solution.licenseKeyFormatting(s, k);
        System.out.println("Formatted license key: " + result); // Expected output: "5F3Z-2E9W"
    }
}

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        int t = 0;
        int cnt = s.length() % k;
        if (cnt == 0) {
            cnt = k;
        }
        for (int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i));
            ++t;
            if (t == cnt) {
                t = 0;
                cnt = k;
                if (i != s.length() - 1) {
                    sb.append('-');
                }
            }
        }
        return sb.toString();
    }
}