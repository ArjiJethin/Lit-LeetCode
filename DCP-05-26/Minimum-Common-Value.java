1public class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        Set<Integer> set1 = new HashSet<>();
4
5        // Add the elements from nums1 to set1
6        for (int num : nums1) {
7            set1.add(num);
8        }
9
10        // Search for each element of nums2 in set1
11        // Return the first common element found
12        for (int num : nums2) {
13            if (set1.contains(num)) {
14                return num;
15            }
16        }
17
18        // Return -1 if there are no common elements
19        return -1;
20    }
21}