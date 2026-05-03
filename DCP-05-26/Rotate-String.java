1class Solution {
2
3    public boolean rotateString(String s, String goal) {
4        if (s.length() != goal.length()) return false;
5        int length = s.length();
6        char[] sChars = s.toCharArray();
7
8        // Try all possible rotations of the string
9        for (int rotationCount = 0; rotationCount < length; ++rotationCount) {
10            // Perform one rotation
11            sChars = rotateOnce(sChars);
12            if (new String(sChars).equals(goal)) return true;
13        }
14        return false;
15    }
16
17    private char[] rotateOnce(char[] arr) {
18        char firstChar = arr[0];
19        System.arraycopy(arr, 1, arr, 0, arr.length - 1);
20        arr[arr.length - 1] = firstChar;
21        return arr;
22    }
23}