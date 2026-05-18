1class Solution {
2    public int minJumps(int[] arr) {
3        int n = arr.length;
4        if (n <= 1) {
5            return 0;
6        }
7
8        Map<Integer, List<Integer>> graph = new HashMap<>();
9        for (int i = 0; i < n; i++) {
10            graph.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
11        }
12
13        List<Integer> curs = new LinkedList<>(); // store current layer
14        curs.add(0);
15        Set<Integer> visited = new HashSet<>();
16        int step = 0;
17
18        // when current layer exists
19        while (!curs.isEmpty()) {
20            List<Integer> nex = new LinkedList<>();
21
22            // iterate the layer
23            for (int node : curs) {
24                // check if reached end
25                if (node == n - 1) {
26                    return step;
27                }
28
29                // check same value
30                for (int child : graph.get(arr[node])) {
31                    if (!visited.contains(child)) {
32                        visited.add(child);
33                        nex.add(child);
34                    }
35                }
36
37                // clear the list to prevent redundant search
38                graph.get(arr[node]).clear();
39
40                // check neighbors
41                if (node + 1 < n && !visited.contains(node + 1)) {
42                    visited.add(node + 1);
43                    nex.add(node + 1);
44                }
45                if (node - 1 >= 0 && !visited.contains(node - 1)) {
46                    visited.add(node - 1);
47                    nex.add(node - 1);
48                }
49            }
50
51            curs = nex;
52            step++;
53        }
54
55        return -1;
56    }
57}