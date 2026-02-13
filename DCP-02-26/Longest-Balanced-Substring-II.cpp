1using namespace std;
2
3class Solution {
4public:
5    int longestBalanced(string s) {
6        int ans = 0;
7
8        //Single character runs
9        ans = max(ans, longestSingle(s));
10
11        //Double character balanced substrings
12        ans = max(ans, longestTwo(s, 'a', 'b'));
13        ans = max(ans, longestTwo(s, 'a', 'c'));
14        ans = max(ans, longestTwo(s, 'b', 'c'));
15
16        //All 3 character balanced substrings
17        ans = max(ans, longestThree(s));
18
19        return ans;
20    }
21
22    // Longest run of a single character
23    int longestSingle(const string &s) {
24        int maxLen = 0;
25        int i = 0, n = s.size();
26        while (i < n) {
27            int j = i;
28            while (j < n && s[j] == s[i]) j++;
29            maxLen = max(maxLen, j - i);
30            i = j;
31        }
32        return maxLen;
33    }
34
35    //balanced substring using two characters
36    int longestTwo(const string &s, char x, char y) {
37        int res = 0;
38        int i = 0, n = s.size();
39        while (i < n) {
40            // Skip other chars not x or y
41            while (i < n && s[i] != x && s[i] != y) i++;
42
43            unordered_map<int, int> pos;
44            pos[0] = i - 1;
45            int diff = 0;
46
47            while (i < n && (s[i] == x || s[i] == y)) {
48                diff += (s[i] == x ? 1 : -1);
49                if (pos.count(diff))
50                    res = max(res, i - pos[diff]);
51                else
52                    pos[diff] = i;
53
54                i++;
55            }
56        }
57        return res;
58    }
59
60    int longestThree(string s) {
61        map<pair<int,int>, int> firstSeen;
62
63        int countA = 0, countB = 0, countC = 0;
64        int ans = 0;
65
66        // Initial state before starting
67        firstSeen[{0, 0}] = -1;
68
69        for (int i = 0; i < s.size(); i++) {
70            if (s[i] == 'a') countA++;
71            else if (s[i] == 'b') countB++;
72            else countC++;
73
74            int d1 = countA - countB;
75            int d2 = countA - countC;
76
77            pair<int,int> state = {d1, d2};
78
79            if (firstSeen.count(state)) {
80                ans = max(ans, i - firstSeen[state]);
81            } else {
82                firstSeen[state] = i;
83            }
84        }
85
86        return ans;
87    }
88
89};