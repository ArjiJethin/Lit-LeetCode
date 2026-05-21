1import java.util.HashSet;
2
3class Solution {
4
5    public int longestCommonPrefix(int[] arr1, int[] arr2) {
6        HashSet<Integer> arr1Prefixes = new HashSet<Integer>(); // Set to store all prefixes from arr1
7
8        // Step 1: Build all possible prefixes from arr1
9        for (int val : arr1) {
10            while (!arr1Prefixes.contains(val) && val > 0) {
11                // Insert current value as a prefix
12                arr1Prefixes.add(val);
13                // Generate the next shorter prefix by removing the last digit
14                val /= 10;
15            }
16        }
17
18        int longestPrefix = 0;
19
20        // Step 2: Check each number in arr2 for the longest matching prefix
21        for (int val : arr2) {
22            while (!arr1Prefixes.contains(val) && val > 0) {
23                // Reduce val by removing the last digit if not found in the prefix set
24                val /= 10;
25            }
26            if (val > 0) {
27                // Length of the matched prefix using log10 to determine the number of digits
28                longestPrefix = Math.max(
29                    longestPrefix,
30                    (int) Math.log10(val) + 1
31                );
32            }
33        }
34
35        return longestPrefix;
36    }
37}