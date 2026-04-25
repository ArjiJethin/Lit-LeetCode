1class Solution {
2
3    public int maxDistance(int side, int[][] points, int k) {
4        List<Long> arr = new ArrayList<>();
5
6        for (int[] p : points) {
7            int x = p[0];
8            int y = p[1];
9            if (x == 0) {
10                arr.add((long) y);
11            } else if (y == side) {
12                arr.add((long) side + x);
13            } else if (x == side) {
14                arr.add(side * 3L - y);
15            } else {
16                arr.add(side * 4L - x);
17            }
18        }
19        Collections.sort(arr);
20
21        long lo = 1;
22        long hi = side;
23        int ans = 0;
24
25        while (lo <= hi) {
26            long mid = (lo + hi) / 2;
27            if (check(arr, side, k, mid)) {
28                lo = mid + 1;
29                ans = (int) mid;
30            } else {
31                hi = mid - 1;
32            }
33        }
34        return ans;
35    }
36
37    private boolean check(List<Long> arr, int side, int k, long limit) {
38        long perimeter = side * 4L;
39
40        for (long start : arr) {
41            long end = start + perimeter - limit;
42            long cur = start;
43
44            for (int i = 0; i < k - 1; i++) {
45                int idx = lowerBound(arr, cur + limit);
46                if (idx == arr.size() || arr.get(idx) > end) {
47                    cur = -1;
48                    break;
49                }
50                cur = arr.get(idx);
51            }
52
53            if (cur >= 0) {
54                return true;
55            }
56        }
57        return false;
58    }
59
60    private int lowerBound(List<Long> arr, long target) {
61        int left = 0;
62        int right = arr.size();
63        while (left < right) {
64            int mid = left + (right - left) / 2;
65            if (arr.get(mid) < target) {
66                left = mid + 1;
67            } else {
68                right = mid;
69            }
70        }
71        return left;
72    }
73}