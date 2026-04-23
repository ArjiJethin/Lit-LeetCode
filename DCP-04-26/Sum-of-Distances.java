1class Solution {
2
3    public long[] distance(int[] nums) {
4        int n = nums.length;
5        Map<Integer, List<Integer>> groups = new HashMap<>();
6        for (int i = 0; i < n; i++) {
7            groups.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
8        }
9        long[] res = new long[n];
10        for (List<Integer> group : groups.values()) {
11            long total = 0;
12            for (int idx : group) {
13                total += idx;
14            }
15            long prefixTotal = 0;
16            int sz = group.size();
17            for (int i = 0; i < sz; i++) {
18                int idx = group.get(i);
19                res[idx] = total - prefixTotal * 2 + (long) idx * (2 * i - sz);
20                prefixTotal += idx;
21            }
22        }
23        return res;
24    }
25}