import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Problem406 {
    public static void main(String[] args) {
        // Example usage
        int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        Solution solution = new Solution();
        int[][] result = solution.reconstructQueue(people);
        for (int[] person : result) {
            System.out.println("[" + person[0] + ", " + person[1] + "]");
        }
    }
}

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ans = new ArrayList<>(people.length);
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}