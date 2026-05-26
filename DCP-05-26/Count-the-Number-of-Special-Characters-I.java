1class Solution {
2
3    public int numberOfSpecialChars(String word) {
4        Set<Character> s = new HashSet<>();
5        for (char c : word.toCharArray()) {
6            s.add(c);
7        }
8        int ans = 0;
9        for (char c = 'a'; c <= 'z'; c++) {
10            if (s.contains(c) && s.contains((char) (c - 'a' + 'A'))) {
11                ans++;
12            }
13        }
14        return ans;
15    }
16}