1class Solution {
2
3    public TreeNode createBinaryTree(int[][] descriptions) {
4        // Sets to track unique children and parents
5        Set<Integer> children = new HashSet<>(), parents = new HashSet<>();
6        // Map to store parent to children relationships
7        Map<Integer, List<int[]>> parentToChildren = new HashMap<>();
8
9        // Build graph from parent to child, and add nodes to HashSets
10        for (int[] d : descriptions) {
11            int parent = d[0], child = d[1], isLeft = d[2];
12            parents.add(parent);
13            parents.add(child);
14            children.add(child);
15            parentToChildren
16                .computeIfAbsent(parent, l -> new ArrayList<>())
17                .add(new int[] { child, isLeft });
18        }
19
20        // Find the root node by checking which node is in parents but not in children
21        parents.removeAll(children);
22        TreeNode root = new TreeNode(parents.iterator().next());
23
24        // Starting from root, use BFS to construct binary tree
25        Queue<TreeNode> queue = new LinkedList<>();
26        queue.offer(root);
27
28        while (!queue.isEmpty()) {
29            TreeNode parent = queue.poll();
30            // Iterate over children of current parent
31            for (int[] childInfo : parentToChildren.getOrDefault(
32                parent.val,
33                Collections.emptyList()
34            )) {
35                int childValue = childInfo[0], isLeft = childInfo[1];
36                TreeNode child = new TreeNode(childValue);
37                queue.offer(child);
38                // Attach child node to its parent based on isLeft flag
39                if (isLeft == 1) {
40                    parent.left = child;
41                } else {
42                    parent.right = child;
43                }
44            }
45        }
46
47        return root;
48    }
49}