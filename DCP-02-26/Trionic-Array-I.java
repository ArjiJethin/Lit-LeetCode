1class Solution {
2    public boolean isTrionic(int[] nums) {
3        int arrayLength = nums.length;
4        int currentIndex = 0;
5
6        while (currentIndex < arrayLength - 2 && nums[currentIndex] < nums[currentIndex + 1]) {
7            currentIndex++;
8        }
9
10        if (currentIndex == 0) {
11            return false;
12        }
13
14        int peakIndex = currentIndex;
15
16        while (currentIndex < arrayLength - 1 && nums[currentIndex] > nums[currentIndex + 1]) {
17            currentIndex++;
18        }
19
20        if (currentIndex == peakIndex || currentIndex == arrayLength - 1) {
21            return false;
22        }
23
24        while (currentIndex < arrayLength - 1 && nums[currentIndex] < nums[currentIndex + 1]) {
25            currentIndex++;
26        }
27
28        return currentIndex == arrayLength - 1;
29    }
30}
31