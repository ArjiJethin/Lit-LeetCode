1class Solution {
2  // Same as 3314. Construct the Minimum Bitwise Array I
3  public int[] minBitwiseArray(List<Integer> nums) {
4    int[] ans = new int[nums.size()];
5
6    for (int i = 0; i < nums.size(); ++i)
7      ans[i] = nums.get(i) == 2 ? -1 : nums.get(i) - getLeadingOneOfLastGroupOfOnes(nums.get(i));
8
9    return ans;
10  }
11
12  // Returns the leading one of the last group of 1s in the binary
13  // representation of num. For example, if num = 0b10111, the leading one of
14  // the last group of 1s is 0b100.
15  private int getLeadingOneOfLastGroupOfOnes(int num) {
16    int leadingOne = 1;
17    while ((num & leadingOne) > 0)
18      leadingOne <<= 1;
19    return leadingOne >> 1;
20  }
21}