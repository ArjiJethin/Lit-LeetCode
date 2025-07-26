import java.util.List;

public class Problem364 {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        List<NestedInteger> nestedList = List.of(
                new NestedInteger(1),
                new NestedInteger(List.of(new NestedInteger(2), new NestedInteger(3))),
                new NestedInteger(4));
        int result = solution.depthSumInverse(nestedList);
        System.out.println("Depth sum inverse: " + result);
    }
}

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = maxDepth(nestedList);
        return dfs(nestedList, depth);
    }

    private int maxDepth(List<NestedInteger> nestedList) {
        int depth = 1;
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                continue;
            }
            depth = Math.max(depth, 1 + maxDepth(item.getList()));
        }
        return depth;
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int depthSum = 0;
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                depthSum += item.getInteger() * depth;
            } else {
                depthSum += dfs(item.getList(), depth - 1);
            }
        }
        return depthSum;
    }
}