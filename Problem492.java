public class Problem492 {
    public static void main(String[] args) {
        // Example usage
        int area = 4;
        Solution solution = new Solution();
        int[] result = solution.constructRectangle(area);
        System.out.println("Length: " + result[0] + ", Width: " + result[1]); // Expected output: Length: 2, Width: 2
    }
}

class Solution {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            --w;
        }
        return new int[] { area / w, w };
    }
}