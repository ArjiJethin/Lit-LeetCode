import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.TreeMap;

public class Problem314 {
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Solution solution = new Solution();
        List<List<Integer>> result = solution.verticalOrder(root);
        System.out.println("Vertical Order Traversal: " + result);
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.offer(new Pair<>(root, 0));
        TreeMap<Integer, List<Integer>> d = new TreeMap<>();
        while (!q.isEmpty()) {
            for (int n = q.size(); n > 0; --n) {
                var p = q.pollFirst();
                root = p.getKey();
                int offset = p.getValue();
                d.computeIfAbsent(offset, _ -> new ArrayList<>()).add(root.val);
                if (root.left != null) {
                    q.offer(new Pair<>(root.left, offset - 1));
                }
                if (root.right != null) {
                    q.offer(new Pair<>(root.right, offset + 1));
                }
            }
        }
        return new ArrayList<>(d.values());
    }
}

// Simple generic Pair class
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}