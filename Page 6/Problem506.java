
import java.util.Arrays;

public class Problem506 {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean neg = num < 0;
        if (neg) {
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (neg) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }
}

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i1, i2) -> score[i2] - score[i1]);
        String[] ans = new String[n];
        String[] top3 = new String[] { "Gold Medal", "Silver Medal", "Bronze Medal" };
        for (int i = 0; i < n; ++i) {
            ans[idx[i]] = i < 3 ? top3[i] : String.valueOf(i + 1);
        }
        return ans;
    }
}