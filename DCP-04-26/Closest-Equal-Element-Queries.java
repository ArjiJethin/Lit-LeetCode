1class Solution {
2
3    public List<Integer> solveQueries(int[] nums, int[] queries) {
4        int n = nums.length;
5        int[] left = new int[n];
6        int[] right = new int[n];
7
8        HashMap<Integer, Integer> pos = new HashMap<>();
9        for (int i = -n; i < n; i++) {
10            if (i >= 0) {
11                left[i] = pos.getOrDefault(nums[i], i - n);
12            }
13            pos.put(nums[((i % n) + n) % n], i);
14        }
15
16        pos.clear();
17        for (int i = 2 * n - 1; i >= 0; i--) {
18            if (i < n) {
19                right[i] = pos.getOrDefault(nums[i], i + n);
20            }
21            pos.put(nums[i % n], i);
22        }
23
24        List<Integer> result = new ArrayList<>();
25        for (int i = 0; i < queries.length; i++) {
26            int x = queries[i];
27            if (x - left[x] == n) {
28                result.add(-1);
29            } else {
30                result.add(Math.min(x - left[x], right[x] - x));
31            }
32        }
33        return result;
34    }
35}