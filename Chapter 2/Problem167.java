public class Problem167 {
    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        Solution solution = new Solution();
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 1, j = numbers.length;
        while (i < j) {
            int x = numbers[i - 1] + numbers[j - 1];
            if (x == target) {
                return new int[] { i, j };
            }
            if (x < target) {
                ++i;
            } else {
                --j;
            }
        }
        return new int[] { -1, -1 };
    }
}