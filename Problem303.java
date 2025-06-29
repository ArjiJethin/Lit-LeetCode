public class Problem303 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 2, 3, 4, 5 };
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2)); // Output: 6 (1 + 2 + 3)
        System.out.println(numArray.sumRange(1, 3)); // Output: 9 (2 + 3 + 4)
        System.out.println(numArray.sumRange(0, 4)); // Output: 15 (1 + 2 + 3 + 4 + 5)
    }
}

class NumArray {
    private int[] s;

    public NumArray(int[] nums) {
        int n = nums.length;
        s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return s[right + 1] - s[left];
    }
}