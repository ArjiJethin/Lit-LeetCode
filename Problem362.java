import java.util.Map;
import java.util.HashMap;

public class Problem362 {
    public static void main(String[] args) {
        // Example usage
        HitCounter hitCounter = new HitCounter();
        hitCounter.hit(1);
        hitCounter.hit(2);
        hitCounter.hit(3);
        System.out.println(hitCounter.getHits(4)); // Output: 3
        hitCounter.hit(300);
        System.out.println(hitCounter.getHits(300)); // Output: 4
        System.out.println(hitCounter.getHits(301)); // Output: 3
    }
}

class HitCounter {

    private Map<Integer, Integer> counter;

    /** Initialize your data structure here. */
    public HitCounter() {
        counter = new HashMap<>();
    }

    /**
     * Record a hit.
     * 
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        counter.put(timestamp, counter.getOrDefault(timestamp, 0) + 1);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     * 
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int hits = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getKey() + 300 > timestamp) {
                hits += entry.getValue();
            }
        }
        return hits;
    }
}