1class Solution {
2    public List<String> readBinaryWatch(int turnedOn) {
3        List<String> ans = new ArrayList<>();
4        for (int i = 0; i < 12; ++i) {
5            for (int j = 0; j < 60; ++j) {
6                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
7                    ans.add(String.format("%d:%02d", i, j));
8                }
9            }
10        }
11        return ans;
12    }
13}