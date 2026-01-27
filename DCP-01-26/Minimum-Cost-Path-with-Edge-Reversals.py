1class Solution:
2    def minCost(self, n: int, edges: List[List[int]]) -> int:
3        g = [[] for _ in range(n)]
4        for u, v, w in edges:
5            g[u].append((v, w))
6            g[v].append((u, w * 2))
7        pq = [(0, 0)]
8        dist = [inf] * n
9        dist[0] = 0
10        while pq:
11            d, u = heappop(pq)
12            if d > dist[u]:
13                continue
14            if u == n - 1:
15                return d
16            for v, w in g[u]:
17                nd = d + w
18                if nd < dist[v]:
19                    dist[v] = nd
20                    heappush(pq, (nd, v))
21        return -1