import java.util.*;

public class Problem173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class BSTIterator {
    private Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        for (; root != null; root = root.left) {
            stack.offerLast(root);
        }
    }

    public int next() {
        TreeNode cur = stack.pollLast();
        for (TreeNode node = cur.right; node != null; node = node.left) {
            stack.offerLast(node);
        }
        return cur.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}