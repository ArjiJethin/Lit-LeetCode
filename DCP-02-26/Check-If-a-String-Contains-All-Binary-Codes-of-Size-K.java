1class Solution {
2    public boolean hasAllCodes(String s, int k) {
3        Set<String> ss = new HashSet<>();
4        for (int i = 0; i < s.length() - k + 1; ++i) {
5            ss.add(s.substring(i, i + k));
6        }
7        return ss.size() == 1 << k;
8    }
9}