1class Solution {
2
3    /**
4     * Segment tree node
5     */
6    static class Node {
7        int l, r; // segment range
8        int mn, mx; // minimum / maximum prefix sum
9        int lazy; // lazy propagation (range add)
10    }
11
12    /**
13     * Segment tree supporting:
14     * - range add
15     * - find the smallest index with a given prefix sum
16     */
17    static class SegmentTree {
18        Node[] tr;
19
20        SegmentTree(int n) {
21            tr = new Node[n << 2];
22            for (int i = 0; i < tr.length; i++) {
23                tr[i] = new Node();
24            }
25            build(1, 0, n);
26        }
27
28        // Build an empty tree with all prefix sums = 0
29        void build(int u, int l, int r) {
30            tr[u].l = l;
31            tr[u].r = r;
32            tr[u].mn = tr[u].mx = 0;
33            tr[u].lazy = 0;
34            if (l == r) return;
35            int mid = (l + r) >> 1;
36            build(u << 1, l, mid);
37            build(u << 1 | 1, mid + 1, r);
38        }
39
40        // Add value v to all prefix sums in [l, r]
41        void modify(int u, int l, int r, int v) {
42            if (tr[u].l >= l && tr[u].r <= r) {
43                apply(u, v);
44                return;
45            }
46            pushdown(u);
47            int mid = (tr[u].l + tr[u].r) >> 1;
48            if (l <= mid) modify(u << 1, l, r, v);
49            if (r > mid) modify(u << 1 | 1, l, r, v);
50            pushup(u);
51        }
52
53        // Binary search on the segment tree
54        // Find the smallest index where prefix sum == target
55        int query(int u, int target) {
56            if (tr[u].l == tr[u].r) {
57                return tr[u].l;
58            }
59            pushdown(u);
60            int left = u << 1;
61            int right = u << 1 | 1;
62            if (tr[left].mn <= target && target <= tr[left].mx) {
63                return query(left, target);
64            }
65            return query(right, target);
66        }
67
68        // Apply range add
69        void apply(int u, int v) {
70            tr[u].mn += v;
71            tr[u].mx += v;
72            tr[u].lazy += v;
73        }
74
75        // Update from children
76        void pushup(int u) {
77            tr[u].mn = Math.min(tr[u << 1].mn, tr[u << 1 | 1].mn);
78            tr[u].mx = Math.max(tr[u << 1].mx, tr[u << 1 | 1].mx);
79        }
80
81        // Push lazy tag down
82        void pushdown(int u) {
83            if (tr[u].lazy != 0) {
84                apply(u << 1, tr[u].lazy);
85                apply(u << 1 | 1, tr[u].lazy);
86                tr[u].lazy = 0;
87            }
88        }
89    }
90
91    public int longestBalanced(int[] nums) {
92        int n = nums.length;
93        SegmentTree st = new SegmentTree(n);
94
95        // last[x] = last position where value x appeared
96        Map<Integer, Integer> last = new HashMap<>();
97
98        int now = 0; // current prefix sum
99        int ans = 0; // answer
100
101        // Enumerate the right endpoint
102        for (int i = 1; i <= n; i++) {
103            int x = nums[i - 1];
104            int det = (x & 1) == 1 ? 1 : -1;
105
106            // Remove previous contribution if x appeared before
107            if (last.containsKey(x)) {
108                st.modify(1, last.get(x), n, -det);
109                now -= det;
110            }
111
112            // Add current contribution
113            last.put(x, i);
114            st.modify(1, i, n, det);
115            now += det;
116
117            // Find earliest position with the same prefix sum
118            int pos = st.query(1, now);
119            ans = Math.max(ans, i - pos);
120        }
121
122        return ans;
123    }
124}