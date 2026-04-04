1class Solution {
2    public String decodeCiphertext(String encodedText, int rows) {
3        if (rows == 1)
4            return encodedText;
5
6        int n = encodedText.length();
7        int cols = n / rows;
8
9        StringBuilder res = new StringBuilder(n);
10
11        for (int c = 0; c < cols; c++) {
12            int r = 0, j = c;
13            while (r < rows && j < cols) {
14                res.append(encodedText.charAt(r * cols + j));
15                r++;
16                j++;
17            }
18        }
19
20        int end = res.length() - 1;
21        while (end >= 0 && res.charAt(end) == ' ') {
22            end--;
23        }
24
25        return res.substring(0, end + 1);
26    }
27}