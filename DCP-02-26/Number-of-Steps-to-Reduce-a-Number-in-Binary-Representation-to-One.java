1class Solution {
2
3    private void divideByTwo(StringBuilder s) {
4        s.deleteCharAt(s.length() - 1);
5    }
6
7    private void addOne(StringBuilder s) {
8        int i = s.length() - 1;
9
10        // Iterating while the character is 1 and changing to 0
11        while (i >= 0 && s.charAt(i) != '0') {
12            s.setCharAt(i, '0');
13            i--;
14        }
15
16        if (i < 0) {
17            s.insert(0, '1');
18        } else {
19            s.setCharAt(i, '1');
20        }
21    }
22
23    public int numSteps(String s) {
24        StringBuilder str = new StringBuilder(s);
25
26        int operations = 0;
27        while (str.length() > 1) {
28            int N = str.length();
29
30            if (str.charAt(N - 1) == '0') {
31                divideByTwo(str);
32            } else {
33                addOne(str);
34            }
35
36            operations++;
37        }
38
39        return operations;
40    }
41}