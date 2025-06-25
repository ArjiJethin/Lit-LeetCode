
import java.util.Comparator;
import java.util.PriorityQueue;

class Kth_Smallest_Element_in_a_BST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        public int kthSmallest(TreeNode root, int k) {

            dfs(root, k);

            return heap.peek();
        }

        private void dfs(TreeNode root, int k) {

            if (root == null) {
                return;
            }

            // maintain heap
            if (heap.size() < k) {
                heap.offer(root.val);

                // followup question, heap.remove() is by object, not index.
                // so if delete operation, just remove element from both tree and heap

            } else {
                int val = root.val;
                if (val < heap.peek()) {
                    heap.poll();
                    heap.offer(val);
                }
            }
            dfs(root.left, k);
            dfs(root.right, k);
        }
    }

}

class Solution_followUp {
    public int kthSmallest(TreeNode root, int k) {
        MyTreeNode node = build(root);
        return dfs(node, k);
    }

    class MyTreeNode {
        int val;
        int count; // key point to add up and find k-th element
        MyTreeNode left;
        MyTreeNode right;

        MyTreeNode(int x) {
            this.val = x;
            this.count = 1;
        }
    };

    MyTreeNode build(TreeNode root) {
        if (root == null)
            return null;
        MyTreeNode node = new MyTreeNode(root.val);
        node.left = build(root.left);
        node.right = build(root.right);
        if (node.left != null)
            node.count += node.left.count;
        if (node.right != null)
            node.count += node.right.count;
        return node;
    }

    int dfs(MyTreeNode node, int k) {
        if (node.left != null) {
            int cnt = node.left.count;
            if (k <= cnt) {
                return dfs(node.left, k);
            } else if (k > cnt + 1) {
                return dfs(node.right, k - 1 - cnt); // -1 is to exclude current root
            } else { // k == cnt + 1
                return node.val;
            }
        } else {
            if (k == 1)
                return node.val;
            return dfs(node.right, k - 1);
        }
    }
}