public class Problem205 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic("egg", "add")); // Output: true
        System.out.println(solution.isIsomorphic("foo", "bar")); // Output: false
        System.out.println(solution.isIsomorphic("paper", "title")); // Output: true
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] d1 = new int[256];
        int[] d2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char a = s.charAt(i), b = t.charAt(i);
            if (d1[a] != d2[b]) {
                return false;
            }
            d1[a] = i + 1;
            d2[b] = i + 1;
        }
        return true;
    }
}