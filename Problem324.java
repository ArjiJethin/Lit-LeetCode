import java.util.Arrays;

public class Problem324 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { 1, 5, 1, 1, 6, 4 };
        Solution solution = new Solution();
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 6, 1, 5, 1, 4]
    }
}

class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int i = (n - 1) >> 1, j = n - 1;
        for (int k = 0; k < n; ++k) {
            if (k % 2 == 0) {
                nums[k] = arr[i--];
            } else {
                nums[k] = arr[j--];
            }
        }
    }
}