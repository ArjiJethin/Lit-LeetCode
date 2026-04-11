1class Solution {
2
3    public int minimumDistance(int[] nums) {
4        int n = nums.length;
5        int[] next = new int[n];
6        Arrays.fill(next, -1);
7        Map<Integer, Integer> occur = new HashMap<>();
8        int ans = n + 1;
9
10        for (int i = n - 1; i >= 0; i--) {
11            if (occur.containsKey(nums[i])) {
12                next[i] = occur.get(nums[i]);
13            }
14            occur.put(nums[i], i);
15        }
16
17        for (int i = 0; i < n; i++) {
18            int secondPos = next[i];
19            if (secondPos != -1) {
20                int thirdPos = next[secondPos];
21                if (thirdPos != -1) {
22                    ans = Math.min(ans, thirdPos - i);
23                }
24            }
25        }
26
27        return ans == n + 1 ? -1 : ans * 2;
28    }
29}