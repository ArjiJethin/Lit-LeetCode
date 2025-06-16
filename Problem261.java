public class Problem261 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage:
        int n = 5;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        System.out.println(solution.validTree(n, edges)); // Output: true
    }
}

class Solution {
    private int[] p;

    public boolean validTree(int n, int[][] edges) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            if (find(a) == find(b)) {
                return false;
            }
            p[find(a)] = find(b);
            --n;
        }
        return n == 1;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}