1class Solution {
2
3    public int earliestFinishTime(
4        int[] landStartTime,
5        int[] landDuration,
6        int[] waterStartTime,
7        int[] waterDuration
8    ) {
9        int n = landStartTime.length;
10        int m = waterStartTime.length;
11        int res = Integer.MAX_VALUE;
12        for (int i = 0; i < n; i++) {
13            for (int j = 0; j < m; j++) {
14                int land = landStartTime[i] + landDuration[i];
15                int land_water =
16                    Math.max(land, waterStartTime[j]) + waterDuration[j];
17                res = Math.min(res, land_water);
18
19                int water = waterStartTime[j] + waterDuration[j];
20                int water_land =
21                    Math.max(water, landStartTime[i]) + landDuration[i];
22                res = Math.min(res, water_land);
23            }
24        }
25        return res;
26    }
27}