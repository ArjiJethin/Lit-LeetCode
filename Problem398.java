import java.util.Random;

public class Problem398 {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[] { 1, 2, 3, 3, 3 });
        int target = 3; // Example input
        int result = solution.pick(target);
        System.out.println("Picked index for target " + target + ": " + result);
    }
}

class Solution {
    private int[] nums;
    private Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int n = 0, ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                ++n;
                int x = 1 + random.nextInt(n);
                if (x == n) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}