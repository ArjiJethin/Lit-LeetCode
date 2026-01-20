1class Solution {
2  public int[] minBitwiseArray(List<Integer> nums) {
3    int[] ans = new int[nums.size()];
4
5    for (int i = 0; i < nums.size(); ++i)
6      ans[i] = nums.get(i) == 2 ? -1 : nums.get(i) - getLeadingOneOfLastGroupOfOnes(nums.get(i));
7
8    return ans;
9  }
10
11  // Returns the leading one of the last group of 1s in the binary
12  // representation of num. For example, if num = 0b10111, the leading one of
13  // the last group of 1s is 0b100.
14  private int getLeadingOneOfLastGroupOfOnes(int num) {
15    int leadingOne = 1;
16    while ((num & leadingOne) > 0)
17      leadingOne <<= 1;
18    return leadingOne >> 1;
19  }
20}