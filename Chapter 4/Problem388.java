import java.util.Deque;
import java.util.ArrayDeque;

public class Problem388 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        int result = solution.lengthLongestPath(input);
        System.out.println("Length of the longest path: " + result); // Output: 20
    }
}

class Solution {
    public int lengthLongestPath(String input) {
        int i = 0;
        int n = input.length();
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        while (i < n) {
            int ident = 0;
            for (; input.charAt(i) == '\t'; i++) {
                ident++;
            }

            int cur = 0;
            boolean isFile = false;
            for (; i < n && input.charAt(i) != '\n'; i++) {
                cur++;
                if (input.charAt(i) == '.') {
                    isFile = true;
                }
            }
            i++;

            // popd
            while (!stack.isEmpty() && stack.size() > ident) {
                stack.pop();
            }

            if (stack.size() > 0) {
                cur += stack.peek() + 1;
            }

            // pushd
            if (!isFile) {
                stack.push(cur);
                continue;
            }

            ans = Math.max(ans, cur);
        }
        return ans;
    }
}