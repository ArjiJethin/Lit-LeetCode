1class Solution {
2
3    public String findTheString(int[][] lcp) {
4        int n = lcp.length;
5        char[] word = new char[n];
6        char current = 'a';
7
8        // construct the string starting from 'a' to 'z' sequentially
9        for (int i = 0; i < n; i++) {
10            if (word[i] == 0) {
11                if (current > 'z') {
12                    return "";
13                }
14                word[i] = current;
15                for (int j = i + 1; j < n; j++) {
16                    if (lcp[i][j] > 0) {
17                        word[j] = word[i];
18                    }
19                }
20                current++;
21            }
22        }
23
24        // verify if the constructed string meets the LCP matrix requirements
25        for (int i = n - 1; i >= 0; i--) {
26            for (int j = n - 1; j >= 0; j--) {
27                if (word[i] != word[j]) {
28                    if (lcp[i][j] != 0) {
29                        return "";
30                    }
31                } else {
32                    if (i == n - 1 || j == n - 1) {
33                        if (lcp[i][j] != 1) {
34                            return "";
35                        }
36                    } else {
37                        if (lcp[i][j] != lcp[i + 1][j + 1] + 1) {
38                            return "";
39                        }
40                    }
41                }
42            }
43        }
44
45        return new String(word);
46    }
47}