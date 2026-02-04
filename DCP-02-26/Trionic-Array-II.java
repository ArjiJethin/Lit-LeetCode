1class Solution {
2
3    public long maxSumTrionic(int[] nums) {
4        int n = nums.length;
5        long ans = Long.MIN_VALUE;
6
7        for (int i = 0; i < n; i++) {
8            int j = i + 1;
9            long res = 0;
10
11            while (j < n && nums[j - 1] < nums[j]) {
12                j++;
13            }
14            int p = j - 1;
15
16            if (p == i) {
17                continue;
18            }
19
20            res += nums[p] + nums[p - 1];
21            while (j < n && nums[j - 1] > nums[j]) {
22                res += nums[j];
23                j++;
24            }
25            int q = j - 1;
26
27            if (q == p || q == n - 1 || (j < n && nums[j] <= nums[q])) {
28                i = q;
29                continue;
30            }
31
32            res += nums[q + 1];
33
34            long maxSum = 0;
35            long sum = 0;
36            for (int k = q + 2; k < n && nums[k] > nums[k - 1]; k++) {
37                sum += nums[k];
38                maxSum = Math.max(maxSum, sum);
39            }
40            res += maxSum;
41
42            maxSum = 0;
43            sum = 0;
44            for (int k = p - 2; k >= i; k--) {
45                sum += nums[k];
46                maxSum = Math.max(maxSum, sum);
47            }
48            res += maxSum;
49
50            ans = Math.max(ans, res);
51            i = q - 1;
52        }
53
54        return ans;
55    }
56}