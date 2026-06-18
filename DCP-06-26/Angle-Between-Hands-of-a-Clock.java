1class Solution {
2    public double angleClock(int hour, int minutes) {
3        double x = hour + minutes / 60.0;
4        double diff = (11.0 * x) % 12.0;
5        return Math.min(diff, 12.0 - diff) * 30.0;
6    }
7}