public class Problem360 {
    public static void main(String[] args) {
        // Example usage
        int[] nums = { -4, -2, 2, 4 };
        int a = 1, b = 3, c = 5;
        Solution solution = new Solution();
        int[] result = solution.sortTransformedArray(nums, a, b, c);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int i = 0, j = n - 1, k = a < 0 ? 0 : n - 1;
        int[] res = new int[n];
        while (i <= j) {
            int v1 = f(a, b, c, nums[i]), v2 = f(a, b, c, nums[j]);
            if (a < 0) {
                if (v1 <= v2) {
                    res[k] = v1;
                    ++i;
                } else {
                    res[k] = v2;
                    --j;
                }
                ++k;
            } else {
                if (v1 >= v2) {
                    res[k] = v1;
                    ++i;
                } else {
                    res[k] = v2;
                    --j;
                }
                --k;
            }
        }
        return res;
    }

    private int f(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}