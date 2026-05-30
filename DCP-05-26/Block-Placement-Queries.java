1class Solution {
2
3    private int[] seg;
4
5    private void update(int idx, int val, int p, int l, int r) {
6        if (l == r) {
7            seg[p] = val;
8            return;
9        }
10        int mid = (l + r) >> 1;
11        if (idx <= mid) {
12            update(idx, val, p << 1, l, mid);
13        } else {
14            update(idx, val, (p << 1) | 1, mid + 1, r);
15        }
16        seg[p] = Math.max(seg[p << 1], seg[(p << 1) | 1]);
17    }
18
19    private int query(int L, int R, int p, int l, int r) {
20        if (L <= l && r <= R) {
21            return seg[p];
22        }
23        int mid = (l + r) >> 1;
24        int res = 0;
25        if (L <= mid) {
26            res = Math.max(res, query(L, R, p << 1, l, mid));
27        }
28        if (R > mid) {
29            res = Math.max(res, query(L, R, (p << 1) | 1, mid + 1, r));
30        }
31        return res;
32    }
33
34    public List<Boolean> getResults(int[][] queries) {
35        int mx = 50000;
36        seg = new int[mx << 2];
37        TreeSet<Integer> st = new TreeSet<>();
38        st.add(0);
39        st.add(mx);
40        update(mx, mx, 1, 0, mx);
41        List<Boolean> ans = new ArrayList<>();
42
43        for (int[] q : queries) {
44            if (q[0] == 1) {
45                int x = q[1];
46                int r = Optional.ofNullable(st.ceiling(x + 1)).orElse(mx);
47                int l = Optional.ofNullable(st.floor(x - 1)).orElse(0);
48                update(x, x - l, 1, 0, mx);
49                update(r, r - x, 1, 0, mx);
50                st.add(x);
51            } else {
52                int x = q[1];
53                int sz = q[2];
54                int pre = Optional.ofNullable(st.floor(x)).orElse(0);
55                int max_space = query(0, pre, 1, 0, mx);
56                max_space = Math.max(max_space, x - pre);
57                ans.add(max_space >= sz);
58            }
59        }
60        return ans;
61    }
62}