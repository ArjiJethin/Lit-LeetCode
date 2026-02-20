1class Solution {
2    public String makeLargestSpecial(String s) {
3        if ("".equals(s)) {
4            return "";
5        }
6        List<String> ans = new ArrayList<>();
7        int cnt = 0;
8        for (int i = 0, j = 0; i < s.length(); ++i) {
9            cnt += s.charAt(i) == '1' ? 1 : -1;
10            if (cnt == 0) {
11                String t = "1" + makeLargestSpecial(s.substring(j + 1, i)) + "0";
12                ans.add(t);
13                j = i + 1;
14            }
15        }
16        ans.sort(Comparator.reverseOrder());
17        return String.join("", ans);
18    }
19}