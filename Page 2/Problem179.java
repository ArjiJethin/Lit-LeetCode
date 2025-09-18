import java.util.*;

public class Problem179 {
    public static void main(String[] args) {
        int[] nums = { 3, 30, 34, 5, 9 };
        Solution solution = new Solution();
        String result = solution.largestNumber(nums);
        System.out.println("Largest number: " + result);
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        List<String> vs = new ArrayList<>();
        for (int v : nums) {
            vs.add(v + "");
        }
        vs.sort((a, b) -> (b + a).compareTo(a + b));
        if ("0".equals(vs.get(0))) {
            return "0";
        }
        return String.join("", vs);
    }
}