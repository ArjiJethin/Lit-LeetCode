1class Solution {
2
3    public List<String> twoEditWords(String[] queries, String[] dictionary) {
4        List<String> ans = new ArrayList<>();
5        for (String query : queries) {
6            for (String s : dictionary) {
7                int dis = 0;
8                for (int i = 0; i < query.length(); i++) {
9                    if (query.charAt(i) != s.charAt(i)) {
10                        dis++;
11                    }
12                }
13                if (dis <= 2) {
14                    ans.add(query);
15                    break;
16                }
17            }
18        }
19        return ans;
20    }
21}