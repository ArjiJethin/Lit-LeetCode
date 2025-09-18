import java.util.*;

public class Problem170 {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        System.out.println(twoSum.find(4)); // true
        System.out.println(twoSum.find(7)); // false
        twoSum.add(2);
        System.out.println(twoSum.find(3)); // true
    }
}

class TwoSum {
    private Map<Integer, Integer> cnt = new HashMap<>();

    public TwoSum() {
    }

    public void add(int number) {
        cnt.merge(number, 1, Integer::sum);
    }

    public boolean find(int value) {
        for (var e : cnt.entrySet()) {
            int x = e.getKey(), v = e.getValue();
            int y = value - x;
            if (cnt.containsKey(y)) {
                if (x != y || v > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
