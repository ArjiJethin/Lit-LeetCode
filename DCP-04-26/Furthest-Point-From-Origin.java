1class Solution {
2
3    public int furthestDistanceFromOrigin(String moves) {
4        int L = 0;
5        int R = 0;
6        int B = 0;
7        for (char c : moves.toCharArray()) {
8            if (c == 'L') {
9                L++;
10            } else if (c == 'R') {
11                R++;
12            } else {
13                B++;
14            }
15        }
16        return Math.abs(L - R) + B;
17    }
18}