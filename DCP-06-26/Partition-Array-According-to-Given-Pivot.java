1class Solution {
2
3    public int[] pivotArray(int[] nums, int pivot) {
4        LinkedList<Integer> less = new LinkedList<>();
5        LinkedList<Integer> equal = new LinkedList<>();
6        LinkedList<Integer> greater = new LinkedList<>();
7        for (int num : nums) {
8            if (num < pivot) {
9                less.add(num);
10            } else if (num > pivot) {
11                greater.add(num);
12            } else {
13                equal.add(num);
14            }
15        }
16        less.addAll(equal);
17        less.addAll(greater);
18
19        int i = 0;
20        int[] ans = new int[nums.length];
21        for (int num : less) {
22            ans[i++] = num;
23        }
24        return ans;
25    }
26}