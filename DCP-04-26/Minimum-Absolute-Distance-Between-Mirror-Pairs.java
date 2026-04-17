1class Solution {
2
3    public int minMirrorPairDistance(int[] nums) {
4        Map<Integer, Integer> prev = new HashMap<>();
5        int n = nums.length;
6        int ans = n + 1;
7
8        for (int i = 0; i < n; i++) {
9            int x = nums[i];
10            if (prev.containsKey(x)) {
11                ans = Math.min(ans, i - prev.get(x));
12            }
13            prev.put(reverseNum(x), i);
14        }
15
16        return ans == n + 1 ? -1 : ans;
17    }
18
19    private int reverseNum(int x) {
20        int y = 0;
21        while (x > 0) {
22            y = y * 10 + (x % 10);
23            x /= 10;
24        }
25        return y;
26    }
27}