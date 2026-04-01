1class Solution {
2
3    public List<Integer> survivedRobotsHealths(
4        int[] positions,
5        int[] healths,
6        String directions
7    ) {
8        int n = positions.length;
9        Integer[] indices = new Integer[n];
10        List<Integer> result = new ArrayList<>();
11        Stack<Integer> stack = new Stack<>();
12
13        for (int index = 0; index < n; ++index) {
14            indices[index] = index;
15        }
16
17        Arrays.sort(
18            indices,
19            (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs])
20        );
21
22        for (int currentIndex : indices) {
23            // Add right-moving robots to the stack
24            if (directions.charAt(currentIndex) == 'R') {
25                stack.push(currentIndex);
26            } else {
27                while (!stack.isEmpty() && healths[currentIndex] > 0) {
28                    // Pop the top robot from the stack for collision check
29                    int topIndex = stack.pop();
30
31                    // Top robot survives, current robot is destroyed
32                    if (healths[topIndex] > healths[currentIndex]) {
33                        healths[topIndex] -= 1;
34                        healths[currentIndex] = 0;
35                        stack.push(topIndex);
36                    } else if (healths[topIndex] < healths[currentIndex]) {
37                        // Current robot survives, top robot is destroyed
38                        healths[currentIndex] -= 1;
39                        healths[topIndex] = 0;
40                    } else {
41                        // Both robots are destroyed
42                        healths[currentIndex] = 0;
43                        healths[topIndex] = 0;
44                    }
45                }
46            }
47        }
48
49        // Collect surviving robots
50        for (int index = 0; index < n; ++index) {
51            if (healths[index] > 0) {
52                result.add(healths[index]);
53            }
54        }
55        return result;
56    }
57}