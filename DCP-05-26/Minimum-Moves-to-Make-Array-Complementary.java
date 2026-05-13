1class Solution {
2
3    public int minMoves(int[] nums, int limit) {
4        int n = nums.length;
5        Map<Integer, Integer> sumCount = new HashMap<>();
6        int[] minArr = new int[n / 2];
7        int[] maxArr = new int[n / 2];
8
9        for (int i = 0; i < n / 2; i++) {
10            int a = Math.min(nums[i], nums[n - 1 - i]);
11            int b = Math.max(nums[i], nums[n - 1 - i]);
12
13            sumCount.merge(a + b, 1, Integer::sum);
14            minArr[i] = a;
15            maxArr[i] = b;
16        }
17
18        Arrays.sort(minArr);
19        Arrays.sort(maxArr);
20
21        int minOps = n;
22
23        for (int c = 2; c <= 2 * limit; c++) {
24            int addLeft = n / 2 - lowerBound(minArr, c);
25            int addRight = lowerBound(maxArr, c - limit);
26
27            int currentOps =
28                n / 2 + addLeft + addRight - sumCount.getOrDefault(c, 0);
29            minOps = Math.min(minOps, currentOps);
30        }
31
32        return minOps;
33    }
34
35    private int lowerBound(int[] arr, int target) {
36        int left = 0;
37        int right = arr.length;
38        while (left < right) {
39            int mid = (left + right) >>> 1;
40            if (arr[mid] >= target) {
41                right = mid;
42            } else {
43                left = mid + 1;
44            }
45        }
46        return left;
47    }
48}