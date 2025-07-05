public class Problem387 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        int result = solution.firstUniqChar(s);
        System.out.println("First unique character index in \"" + s + "\": " + result);

        s = "loveleetcode";
        result = solution.firstUniqChar(s);
        System.out.println("First unique character index in \"" + s + "\": " + result);

        s = "aabb";
        result = solution.firstUniqChar(s);
        System.out.println("First unique character index in \"" + s + "\": " + result);
    }
}

class Solution {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < n; ++i) {
            if (cnt[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}