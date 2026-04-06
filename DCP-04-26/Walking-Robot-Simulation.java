1class Solution {
2
3    private static final long HASH_MULTIPLIER = 60013; // Slightly larger than 2 * max coordinate value
4
5    public int robotSim(int[] commands, int[][] obstacles) {
6        // Store obstacles in an HashSet for efficient lookup
7        Set<Long> obstacleSet = new HashSet<>();
8        for (int[] obstacle : obstacles) {
9            obstacleSet.add(hashCoordinates(obstacle[0], obstacle[1]));
10        }
11
12        // Define direction vectors: North, East, South, West
13        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
14
15        int[] currentPosition = { 0, 0 };
16        int maxDistanceSquared = 0;
17        int currentDirection = 0; // 0: North, 1: East, 2: South, 3: West
18
19        for (int command : commands) {
20            if (command == -1) {
21                // Turn right
22                currentDirection = (currentDirection + 1) % 4;
23                continue;
24            }
25            if (command == -2) {
26                // Turn left
27                currentDirection = (currentDirection + 3) % 4;
28                continue;
29            }
30
31            // Move forward
32            int[] direction = directions[currentDirection];
33            for (int step = 0; step < command; step++) {
34                int nextX = currentPosition[0] + direction[0];
35                int nextY = currentPosition[1] + direction[1];
36                if (obstacleSet.contains(hashCoordinates(nextX, nextY))) {
37                    break;
38                }
39                currentPosition[0] = nextX;
40                currentPosition[1] = nextY;
41            }
42
43            maxDistanceSquared = Math.max(
44                maxDistanceSquared,
45                currentPosition[0] * currentPosition[0] +
46                currentPosition[1] * currentPosition[1]
47            );
48        }
49
50        return maxDistanceSquared;
51    }
52
53    // Hash function to convert (x, y) coordinates to a unique integer value
54    private long hashCoordinates(long x, long y) {
55        return x + HASH_MULTIPLIER * y;
56    }
57}