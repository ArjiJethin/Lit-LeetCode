1class Solution {
2    public long minimumCost(int[] nums, int k, int dist) {
3        long result = Long.MAX_VALUE, sum = 0L;
4        int n = nums.length;
5        TreeSet<Integer> set1
6            = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
7        TreeSet<Integer> set2
8            = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
9        for (int i = 1; i < n; i++) {
10            set1.add(i);
11            sum += nums[i];
12            if (set1.size() >= k) {
13                int x = set1.pollLast();
14                sum -= nums[x];
15                set2.add(x);
16            }
17            if (i - dist > 0) {
18                result = Math.min(result, sum);
19                int temp = i - dist;
20                if (set1.contains(temp)) {
21                    set1.remove(temp);
22                    sum -= nums[temp];
23                    if (set2.size() > 0) {
24                        int y = set2.pollFirst();
25                        sum += nums[y];
26                        set1.add(y);
27                    }
28                } else {
29                    set2.remove(i - dist);
30                }
31            }
32        }
33        return result + nums[0];
34    }
35}