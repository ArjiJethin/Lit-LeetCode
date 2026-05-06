1class Solution {
2
3    public char[][] rotateTheBox(char[][] box) {
4        int m = box.length;
5        int n = box[0].length;
6        char[][] result = new char[n][m];
7
8        // Create the transpose of the input grid in `result`
9        for (int i = 0; i < n; i++) {
10            for (int j = 0; j < m; j++) {
11                result[i][j] = box[j][i];
12            }
13        }
14
15        // Reverse each row in the transpose grid to complete the 90° rotation
16        for (int i = 0; i < n; i++) {
17            reverse(result[i]);
18        }
19
20        // Apply gravity to let stones fall to the lowest possible empty cell in each column
21        for (int j = 0; j < m; j++) {
22            // Process each cell in column `j` from bottom to top
23            for (int i = n - 1; i >= 0; i--) {
24                if (result[i][j] == '.') { // Found an empty cell; check if a stone can fall into it
25                    int nextRowWithStone = -1;
26
27                    // Look for a stone directly above the empty cell `result[i][j]`
28                    for (int k = i - 1; k >= 0; k--) {
29                        if (result[k][j] == '*') break; // Obstacle blocks any stones above
30                        if (result[k][j] == '#') { // Stone found with no obstacles in between
31                            nextRowWithStone = k;
32                            break;
33                        }
34                    }
35
36                    // If a stone was found above, let it fall into the empty cell `result[i][j]`
37                    if (nextRowWithStone != -1) {
38                        result[nextRowWithStone][j] = '.';
39                        result[i][j] = '#';
40                    }
41                }
42            }
43        }
44        return result;
45    }
46
47    // Helper function to reverse an array
48    private void reverse(char[] row) {
49        int left = 0;
50        int right = row.length - 1;
51        while (left < right) {
52            char temp = row[left];
53            row[left] = row[right];
54            row[right] = temp;
55            left++;
56            right--;
57        }
58    }
59}
60