1class Solution {
2
3    public int[] separateDigits(int[] nums) {
4        List<Integer> res = new ArrayList<>();
5        for (int i = nums.length - 1; i >= 0; i--) {
6            int x = nums[i];
7            while (x > 0) {
8                res.add(x % 10);
9                x /= 10;
10            }
11        }
12
13        Collections.reverse(res);
14        int[] result = new int[res.size()];
15        for (int i = 0; i < res.size(); i++) {
16            result[i] = res.get(i);
17        }
18        return result;
19    }
20}