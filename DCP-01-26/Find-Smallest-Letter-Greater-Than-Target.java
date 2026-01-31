1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        int left = 0, right = letters.length;
4        while (left < right) {
5            int mid = (left + right) >> 1;
6            if (letters[mid] > target) {
7                right = mid;
8            } else {
9                left = mid + 1;
10            }
11        }
12        return letters[left % letters.length];
13    }
14}