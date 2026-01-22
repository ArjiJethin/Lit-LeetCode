1class Solution {
2  public int minimumPairRemoval(int[] nums) {
3    int ans = 0;
4    List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
5
6    while (hasInversion(numsList)) {
7      List<Integer> pairSums = new ArrayList<>();
8      for (int i = 0; i < numsList.size() - 1; ++i)
9        pairSums.add(numsList.get(i) + numsList.get(i + 1));
10      int minPairSum = Integer.MAX_VALUE;
11      int minPairIndex = -1;
12      for (int i = 0; i < pairSums.size(); ++i)
13        if (pairSums.get(i) < minPairSum) {
14          minPairSum = pairSums.get(i);
15          minPairIndex = i;
16        }
17      numsList.set(minPairIndex, minPairSum);
18      numsList.remove(minPairIndex + 1);
19      ++ans;
20    }
21
22    return ans;
23  }
24
25  private boolean hasInversion(List<Integer> nums) {
26    for (int i = 0; i < nums.size() - 1; ++i)
27      if (nums.get(i) > nums.get(i + 1))
28        return true;
29    return false;
30  }
31}