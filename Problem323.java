public class Problem323 {
    public static void main(String[] args) {
        // Example usage
        int n = 5;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        Solution solution = new Solution();
        System.out.println(solution.countComponents(n, edges)); // Output: 2
    }
}

class Solution {
    private int[] p;

    public int countComponents(int n, int[][] edges) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            p[find(a)] = find(b);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i == find(i)) {
                ++ans;
            }
        }
        return ans;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}