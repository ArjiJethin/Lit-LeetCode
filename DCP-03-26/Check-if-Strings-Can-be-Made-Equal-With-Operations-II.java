1class Solution {
2
3    public boolean checkStrings(String s1, String s2) {
4        if (s1.length() != s2.length()) {
5            return false;
6        }
7
8        int[] count1 = new int[256];
9        int[] count2 = new int[256];
10
11        for (int i = 0; i < s1.length(); i++) {
12            int offset = (i & 1) << 7;
13            count1[offset + s1.charAt(i)]++;
14            count2[offset + s2.charAt(i)]++;
15        }
16
17        return Arrays.equals(count1, count2);
18    }
19}