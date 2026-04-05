1class Solution {
2    public boolean judgeCircle(String moves) {
3        int x = 0, y = 0;
4        for (char move: moves.toCharArray()) {
5            if (move == 'U') y--;
6            else if (move == 'D') y++;
7            else if (move == 'L') x--;
8            else if (move == 'R') x++;
9        }
10        return x == 0 && y == 0;
11    }
12}