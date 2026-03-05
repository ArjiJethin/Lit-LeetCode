1class Solution {
2    public int minOperations(String s) {
3        int op1 = 0, op2 = 0;
4        int length = s.length();
5        for (int i = 0; i < length; i++) {
6            char c = s.charAt(i);
7            if (i % 2 == 0) {
8                if (c == '1')
9                    op1++;
10                else
11                    op2++;
12            } else {
13                if (c == '1')
14                    op2++;
15                else
16                    op1++;
17            }
18        }
19        return Math.min(op1, op2);
20    }
21}