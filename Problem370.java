public class Problem370 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int length = 5;
        int[][] updates = { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } };
        int[] result = solution.getModifiedArray(length, updates);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] d = new int[length];
        for (var e : updates) {
            int l = e[0], r = e[1], c = e[2];
            d[l] += c;
            if (r + 1 < length) {
                d[r + 1] -= c;
            }
        }
        for (int i = 1; i < length; ++i) {
            d[i] += d[i - 1];
        }
        return d;
    }
}