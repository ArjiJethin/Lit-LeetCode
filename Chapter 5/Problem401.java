import java.util.List;
import java.util.ArrayList;

public class Problem401 {
    public static void main(String[] args) {
        // Example usage
        int turnedOn = 1;
        Solution solution = new Solution();
        List<String> result = solution.readBinaryWatch(turnedOn);
        System.out.println(result); // Expected output: ["0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00",
                                    // "2:00", "4:00", "8:00"]
    }
}

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 60; ++j) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    ans.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return ans;
    }
}