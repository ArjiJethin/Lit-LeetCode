
public class Problem165 {
    public static void main(String[] args) {
        String version1 = "1.01";
        String version2 = "1.001";
        Solution solution = new Solution();
        int result = solution.compareVersion(version1, version2);
        System.out.println("Comparison result: " + result);
    }
}

class Solution {
    public int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        for (int i = 0, j = 0; i < m || j < n; ++i, ++j) {
            int a = 0, b = 0;
            while (i < m && version1.charAt(i) != '.') {
                a = a * 10 + (version1.charAt(i++) - '0');
            }
            while (j < n && version2.charAt(j) != '.') {
                b = b * 10 + (version2.charAt(j++) - '0');
            }
            if (a != b) {
                return a < b ? -1 : 1;
            }
        }
        return 0;
    }
}