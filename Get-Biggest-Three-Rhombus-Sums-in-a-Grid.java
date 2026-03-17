1class Answer {
2
3    int[] ans;
4
5    public Answer() {
6        ans = new int[3];
7    }
8
9    void put(int x) {
10        if (x > ans[0]) {
11            ans[2] = ans[1];
12            ans[1] = ans[0];
13            ans[0] = x;
14        } else if (x != ans[0] && x > ans[1]) {
15            ans[2] = ans[1];
16            ans[1] = x;
17        } else if (x != ans[0] && x != ans[1] && x > ans[2]) {
18            ans[2] = x;
19        }
20    }
21
22    List<Integer> get() {
23        List<Integer> ret = new ArrayList<>();
24        for (int num : ans) {
25            if (num != 0) {
26                ret.add(num);
27            }
28        }
29        return ret;
30    }
31}
32
33class Solution {
34
35    public int[] getBiggestThree(int[][] grid) {
36        int m = grid.length;
37        int n = grid[0].length;
38        int[][] sum1 = new int[m + 1][n + 2];
39        int[][] sum2 = new int[m + 1][n + 2];
40
41        for (int i = 1; i <= m; ++i) {
42            for (int j = 1; j <= n; ++j) {
43                sum1[i][j] = sum1[i - 1][j - 1] + grid[i - 1][j - 1];
44                sum2[i][j] = sum2[i - 1][j + 1] + grid[i - 1][j - 1];
45            }
46        }
47
48        Answer ans = new Answer();
49        for (int i = 0; i < m; ++i) {
50            for (int j = 0; j < n; ++j) {
51                // a single cell is also a rhombus
52                ans.put(grid[i][j]);
53                for (int k = i + 2; k < m; k += 2) {
54                    int ux = i;
55                    int uy = j;
56                    int dx = k;
57                    int dy = j;
58                    int lx = (i + k) / 2;
59                    int ly = j - (k - i) / 2;
60                    int rx = (i + k) / 2;
61                    int ry = j + (k - i) / 2;
62                    if (ly < 0 || ry >= n) {
63                        break;
64                    }
65                    int sum =
66                        (sum2[lx + 1][ly + 1] - sum2[ux][uy + 2]) +
67                        (sum1[rx + 1][ry + 1] - sum1[ux][uy]) +
68                        (sum1[dx + 1][dy + 1] - sum1[lx][ly]) +
69                        (sum2[dx + 1][dy + 1] - sum2[rx][ry + 2]) -
70                        (grid[ux][uy] +
71                            grid[dx][dy] +
72                            grid[lx][ly] +
73                            grid[rx][ry]);
74                    ans.put(sum);
75                }
76            }
77        }
78
79        List<Integer> resultList = ans.get();
80        int[] result = new int[resultList.size()];
81        for (int i = 0; i < resultList.size(); i++) {
82            result[i] = resultList.get(i);
83        }
84        return result;
85    }
86}