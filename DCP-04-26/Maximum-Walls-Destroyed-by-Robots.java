1class Solution {
2
3    public int maxWalls(int[] robots, int[] distance, int[] walls) {
4        int n = robots.length;
5        int[] left = new int[n];
6        int[] right = new int[n];
7        int[] num = new int[n];
8        Map<Integer, Integer> robotsToDistance = new HashMap<>();
9
10        for (int i = 0; i < n; i++) {
11            robotsToDistance.put(robots[i], distance[i]);
12        }
13
14        Arrays.sort(robots);
15        Arrays.sort(walls);
16
17        for (int i = 0; i < n; i++) {
18            int pos1 = upperBound(walls, robots[i]);
19
20            int leftPos = 0;
21            if (i >= 1) {
22                int leftBound = Math.max(
23                    robots[i] - robotsToDistance.get(robots[i]),
24                    robots[i - 1] + 1
25                );
26                leftPos = lowerBound(walls, leftBound);
27            } else {
28                leftPos = lowerBound(
29                    walls,
30                    robots[i] - robotsToDistance.get(robots[i])
31                );
32            }
33            left[i] = pos1 - leftPos;
34
35            int rightPos = 0;
36            if (i < n - 1) {
37                int rightBound = Math.min(
38                    robots[i] + robotsToDistance.get(robots[i]),
39                    robots[i + 1] - 1
40                );
41                rightPos = upperBound(walls, rightBound);
42            } else {
43                rightPos = upperBound(
44                    walls,
45                    robots[i] + robotsToDistance.get(robots[i])
46                );
47            }
48            int pos2 = lowerBound(walls, robots[i]);
49            right[i] = rightPos - pos2;
50
51            if (i == 0) {
52                continue;
53            }
54            int pos3 = lowerBound(walls, robots[i - 1]);
55            num[i] = pos1 - pos3;
56        }
57
58        int subLeft = left[0];
59        int subRight = right[0];
60        for (int i = 1; i < n; i++) {
61            int currentLeft = Math.max(
62                subLeft + left[i],
63                subRight -
64                right[i - 1] +
65                Math.min(left[i] + right[i - 1], num[i])
66            );
67            int currentRight = Math.max(
68                subLeft + right[i],
69                subRight + right[i]
70            );
71            subLeft = currentLeft;
72            subRight = currentRight;
73        }
74
75        return Math.max(subLeft, subRight);
76    }
77
78    private int lowerBound(int[] arr, int target) {
79        int left = 0;
80        int right = arr.length;
81        while (left < right) {
82            int mid = left + (right - left) / 2;
83            if (arr[mid] < target) {
84                left = mid + 1;
85            } else {
86                right = mid;
87            }
88        }
89        return left;
90    }
91
92    private int upperBound(int[] arr, int target) {
93        int left = 0;
94        int right = arr.length;
95        while (left < right) {
96            int mid = left + (right - left) / 2;
97            if (arr[mid] <= target) {
98                left = mid + 1;
99            } else {
100                right = mid;
101            }
102        }
103        return left;
104    }
105}