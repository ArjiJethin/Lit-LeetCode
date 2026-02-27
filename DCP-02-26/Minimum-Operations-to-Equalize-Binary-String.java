1class Solution {
2
3    public int minOperations(String s, int k) {
4        int n = s.length();
5        int m = 0;
6        int[] dist = new int[n + 1];
7        Arrays.fill(dist, Integer.MAX_VALUE);
8        List<TreeSet<Integer>> nodeSets = new ArrayList<>();
9        nodeSets.add(new TreeSet<>());
10        nodeSets.add(new TreeSet<>());
11        for (int i = 0; i <= n; i++) {
12            nodeSets.get(i % 2).add(i);
13            if (i < n && s.charAt(i) == '0') {
14                m++;
15            }
16        }
17        Queue<Integer> q = new ArrayDeque<>();
18        q.offer(m);
19        dist[m] = 0;
20        nodeSets.get(m % 2).remove(m);
21        while (!q.isEmpty()) {
22            m = q.poll();
23            int c1 = Math.max(k - n + m, 0);
24            int c2 = Math.min(m, k);
25            int lnode = m + k - 2 * c2;
26            int rnode = m + k - 2 * c1;
27            TreeSet<Integer> nodeSet = nodeSets.get(lnode % 2);
28            for (
29                Integer m2 = nodeSet.ceiling(lnode);
30                m2 != null && m2 <= rnode;
31                m2 = nodeSet.ceiling(lnode)
32            ) {
33                dist[m2] = dist[m] + 1;
34                q.offer(m2);
35                nodeSet.remove(m2);
36            }
37        }
38        return dist[0] == Integer.MAX_VALUE ? -1 : dist[0];
39    }
40}