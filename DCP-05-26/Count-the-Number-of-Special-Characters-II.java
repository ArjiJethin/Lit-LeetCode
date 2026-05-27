1class Solution {
2
3    public int numberOfSpecialChars(String word) {
4        int[] lastLow = new int[26];
5        int[] firstUp = new int[26];
6        Arrays.fill(lastLow, -1);
7        Arrays.fill(firstUp, -1);
8        for (int i = 0; i < word.length(); i++) {
9            char c = word.charAt(i);
10            if (Character.isLowerCase(c)) {
11                lastLow[c - 'a'] = i;
12            } else {
13                if (firstUp[c - 'A'] == -1) {
14                    firstUp[c - 'A'] = i;
15                }
16            }
17        }
18        int ans = 0;
19        for (int i = 0; i < 26; i++) {
20            if (
21                lastLow[i] != -1 && firstUp[i] != -1 && lastLow[i] < firstUp[i]
22            ) {
23                ans++;
24            }
25        }
26        return ans;
27    }
28}