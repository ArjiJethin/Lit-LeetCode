1class Solution {
2
3    public String generateString(String str1, String str2) {
4        int n = str1.length();
5        int m = str2.length();
6        char[] s = new char[n + m - 1];
7        int[] fixed = new int[n + m - 1];
8
9        for (int i = 0; i < s.length; i++) {
10            s[i] = 'a';
11        }
12
13        for (int i = 0; i < n; i++) {
14            if (str1.charAt(i) == 'T') {
15                for (int j = i; j < i + m; j++) {
16                    if (fixed[j] == 1 && s[j] != str2.charAt(j - i)) {
17                        return "";
18                    } else {
19                        s[j] = str2.charAt(j - i);
20                        fixed[j] = 1;
21                    }
22                }
23            }
24        }
25
26        for (int i = 0; i < n; i++) {
27            if (str1.charAt(i) == 'F') {
28                boolean flag = false;
29                int idx = -1;
30                for (int j = i + m - 1; j >= i; j--) {
31                    if (str2.charAt(j - i) != s[j]) {
32                        flag = true;
33                    }
34                    if (idx == -1 && fixed[j] == 0) {
35                        idx = j;
36                    }
37                }
38                if (flag) {
39                    continue;
40                } else if (idx != -1) {
41                    s[idx] = 'b';
42                } else {
43                    return "";
44                }
45            }
46        }
47        return new String(s);
48    }
49}