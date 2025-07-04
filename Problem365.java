public class Problem365 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int jug1Capacity = 3; // Example jug 1 capacity
        int jug2Capacity = 5; // Example jug 2 capacity
        int targetCapacity = 4; // Example target capacity
        boolean result = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity);
        System.out.println("Can measure " + targetCapacity + " units of water: " + result);
    }
}

class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        }
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}