import java.util.List;

public class Problem339 {
    public static void main(String[] args) {
        // Example usage
        List<NestedInteger> nestedList = List.of(
                new NestedInteger(1),
                new NestedInteger(List.of(new NestedInteger(2), new NestedInteger(3))),
                new NestedInteger(4));
        Solution solution = new Solution();
        System.out.println(solution.depthSum(nestedList)); // Output: 10
    }
}

// This is a minimal implementation for testing purposes.
class NestedInteger {
    private Integer value;
    private List<NestedInteger> list;

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
        this.list = null;
    }

    // Constructor initializes a nested list.
    public NestedInteger(List<NestedInteger> list) {
        this.value = null;
        this.list = list;
    }

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger() {
        return value != null;
    }

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    public Integer getInteger() {
        return value;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    public List<NestedInteger> getList() {
        return list;
    }
}

class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedList, int depth) {
        int depthSum = 0;
        for (NestedInteger item : nestedList) {
            if (item.isInteger()) {
                depthSum += item.getInteger() * depth;
            } else {
                depthSum += dfs(item.getList(), depth + 1);
            }
        }
        return depthSum;
    }
}