1class Solution {
2    public String addBinary(String a, String b) {
3        var sb = new StringBuilder();
4        int i = a.length() - 1, j = b.length() - 1;
5        for (int carry = 0; i >= 0 || j >= 0 || carry > 0; --i, --j) {
6            carry += (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0);
7            sb.append(carry % 2);
8            carry /= 2;
9        }
10        return sb.reverse().toString();
11    }
12}