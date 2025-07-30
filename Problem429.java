import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class Problem429 {
    public static void main(String[] args) {
        // Example usage
        Node root = new Node(1, Arrays.asList(new Node(2), new Node(3, Arrays.asList(new Node(4)))));
        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> t = new ArrayList<>();
            for (int n = q.size(); n > 0; --n) {
                root = q.poll();
                t.add(root.val);
                q.addAll(root.children);
            }
            ans.add(t);
        }
        return ans;
    }
}