1class Solution {
2  public int minimumPairRemoval(int[] nums) {
3    final int n = nums.length;
4    int ans = 0;
5    int inversionsCount = 0;
6    int[] nextIndices = new int[n];
7    int[] prevIndices = new int[n];
8    long[] values = Arrays.stream(nums).asLongStream().toArray();
9    TreeSet<Pair<Long, Integer>> pairSums =
10        new TreeSet<>(Comparator.comparingLong(Pair<Long, Integer>::getKey)
11                          .thenComparingInt(Pair<Long, Integer>::getValue));
12
13    for (int i = 0; i < n; ++i) {
14      nextIndices[i] = i + 1;
15      prevIndices[i] = i - 1;
16    }
17
18    for (int i = 0; i < n - 1; ++i)
19      pairSums.add(new Pair<>((long) nums[i] + nums[i + 1], i));
20
21    for (int i = 0; i < n - 1; ++i)
22      if (nums[i + 1] < nums[i])
23        ++inversionsCount;
24
25    while (inversionsCount > 0) {
26      ++ans;
27      Pair<Long, Integer> smallestPair = pairSums.pollFirst();
28      final long pairSum = smallestPair.getKey();
29      final int currIndex = smallestPair.getValue();
30      final int nextIndex = nextIndices[currIndex];
31      final int prevIndex = prevIndices[currIndex];
32      if (prevIndex >= 0) {
33        final long oldPairSum = values[prevIndex] + values[currIndex];
34        final long newPairSum = values[prevIndex] + pairSum;
35        pairSums.remove(new Pair<>(oldPairSum, prevIndex));
36        pairSums.add(new Pair<>(newPairSum, prevIndex));
37        if (values[prevIndex] > values[currIndex])
38          --inversionsCount;
39        if (values[prevIndex] > pairSum)
40          ++inversionsCount;
41      }
42
43      if (values[nextIndex] < values[currIndex])
44        --inversionsCount;
45
46      final int nextNextIndex = (nextIndex < n) ? nextIndices[nextIndex] : n;
47      if (nextNextIndex < n) {
48        final long oldPairSum = values[nextIndex] + values[nextNextIndex];
49        final long newPairSum = pairSum + values[nextNextIndex];
50        pairSums.remove(new Pair<>(oldPairSum, nextIndex));
51        pairSums.add(new Pair<>(newPairSum, currIndex));
52        if (values[nextNextIndex] < values[nextIndex])
53          --inversionsCount;
54        if (values[nextNextIndex] < pairSum)
55          ++inversionsCount;
56        prevIndices[nextNextIndex] = currIndex;
57      }
58
59      nextIndices[currIndex] = nextNextIndex;
60      values[currIndex] = pairSum;
61    }
62
63    return ans;
64  }
65}