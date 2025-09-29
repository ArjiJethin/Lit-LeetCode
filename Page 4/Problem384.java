import java.util.Random;
import java.util.Arrays;

public class Problem384 {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[] { 1, 2, 3, 4, 5 });
        System.out.println("Original array: " + Arrays.toString(solution.reset()));
        System.out.println("Shuffled array: " + Arrays.toString(solution.shuffle()));
        System.out.println("Reset to original: " + Arrays.toString(solution.reset()));
    }
}

class Solution {
    private int[] nums;
    private int[] original;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.original = Arrays.copyOf(nums, nums.length);
        this.rand = new Random();
    }

    public int[] reset() {
        nums = Arrays.copyOf(original, original.length);
        return nums;
    }

    public int[] shuffle() {
        for (int i = 0; i < nums.length; ++i) {
            swap(i, i + rand.nextInt(nums.length - i));
        }
        return nums;
    }

    private void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}