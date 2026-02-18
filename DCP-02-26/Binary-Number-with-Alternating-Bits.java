1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        String bits = Integer.toBinaryString(n);
4        for (int i = 0; i < bits.length() - 1; i++) {
5            if (bits.charAt(i) == bits.charAt(i+1)) {
6                return false;
7            }
8        }
9        return true;
10    }
11}