public class Problem277 {
    public static void main(String[] args) {
        // Example usage
        int n = 4; // Number of people
        Solution solution = new Solution();
        int celebrity = solution.findCelebrity(n);
        System.out.println(celebrity); // Expected output: index of the celebrity or -1 if none exists
    }
}

class Relation {
    // Mock implementation for knows; replace with actual logic as needed
    // For example, you can define a matrix or logic to simulate the "knows"
    // relationship
    boolean knows(int a, int b) {
        // Example: everyone knows person 2 except person 2 knows no one
        return b == 2 && a != 2;
    }
}

class Solution extends Relation {
    public int findCelebrity(int n) {
        int ans = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(ans, i)) {
                ans = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (ans != i) {
                if (knows(ans, i) || !knows(i, ans)) {
                    return -1;
                }
            }
        }
        return ans;
    }
}