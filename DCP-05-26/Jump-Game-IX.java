1class Solution {
2
3    // [value, index]
4    record Item(int value, int index) {}
5
6    public int[] maxValue(int[] nums) {
7        int n = nums.length;
8        int[] ans = new int[n];
9        Item[] prevMax = new Item[n];
10
11        Item prev = new Item(Integer.MIN_VALUE, -1);
12        for (int i = 0; i < n; i++) {
13            if (nums[i] > prev.value()) {
14                prev = new Item(nums[i], i);
15            }
16            prevMax[i] = prev;
17        }
18
19        process(n - 1, Integer.MAX_VALUE, 0, prevMax, ans, nums);
20        return ans;
21    }
22
23    private void process(
24        int r,
25        int rightMin,
26        int rightMax,
27        Item[] prevMax,
28        int[] ans,
29        int[] nums
30    ) {
31        int pMax = prevMax[r].value();
32        int pivotIndex = prevMax[r].index();
33
34        int currMax = pMax <= rightMin ? pMax : rightMax;
35
36        int nextRightMin = Math.min(pMax, rightMin);
37        for (int i = pivotIndex; i <= r; i++) {
38            ans[i] = currMax;
39            nextRightMin = Math.min(nextRightMin, nums[i]);
40        }
41
42        if (pivotIndex == 0) {
43            return;
44        }
45
46        process(pivotIndex - 1, nextRightMin, currMax, prevMax, ans, nums);
47    }
48}