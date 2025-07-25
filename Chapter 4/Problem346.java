public class Problem346 {
    public static void main(String[] args) {
        // Example usage
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1)); // Output: 1.0
        System.out.println(ma.next(10)); // Output: 5.5
        System.out.println(ma.next(3)); // Output: 4.66667
        System.out.println(ma.next(5)); // Output: 6.0
    }
}

class MovingAverage {
    private int[] arr;
    private int s;
    private int cnt;

    public MovingAverage(int size) {
        arr = new int[size];
    }

    public double next(int val) {
        int idx = cnt % arr.length;
        s += val - arr[idx];
        arr[idx] = val;
        ++cnt;
        return s * 1.0 / Math.min(cnt, arr.length);
    }
}