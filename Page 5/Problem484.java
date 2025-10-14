public class Problem484 {
    public static void main(String[] args) {
        // Example usage
        String s = "IDID";
        Solution solution = new Solution();
        int[] result = solution.findPermutation(s);
        System.out.print("Permutation: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Expected output: A permutation of numbers from 1 to n+1 based on the pattern
        // in s
    }
}

class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            ans[i] = i + 1;
        }
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == 'D') {
                ++j;
            }
            reverse(ans, i, j);
            i = Math.max(i + 1, j);
        }
        return ans;
    }

    private void reverse(int[] arr, int i, int j) {
        for (; i < j; ++i, --j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}