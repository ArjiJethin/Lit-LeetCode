1class Solution {
2
3    private static final double EPS = 1e-7;
4
5    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
6        int maxWorkerTimes = 0;
7        for (int t : workerTimes) {
8            maxWorkerTimes = Math.max(maxWorkerTimes, t);
9        }
10
11        long l = 1;
12        long r =
13            ((long) maxWorkerTimes * mountainHeight * (mountainHeight + 1)) / 2;
14        long ans = 0;
15
16        while (l <= r) {
17            long mid = (l + r) / 2;
18            long cnt = 0;
19            for (int t : workerTimes) {
20                long work = mid / t;
21                // find the largest k such that 1+2+...+k <= work
22                long k = (long) ((-1.0 + Math.sqrt(1 + work * 8)) / 2 + EPS);
23                cnt += k;
24            }
25
26            if (cnt >= mountainHeight) {
27                ans = mid;
28                r = mid - 1;
29            } else {
30                l = mid + 1;
31            }
32        }
33
34        return ans;
35    }
36}