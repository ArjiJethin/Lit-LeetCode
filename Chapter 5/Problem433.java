import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;
import java.util.AbstractMap;

public class Problem433 {
    public static void main(String[] args) {
        // Example usage
        String start = "AAAA";
        String end = "AAAC";
        String[] bank = { "AAAC", "AAAG", "AAAT", "AAGG", "AGGG" };
        Solution solution = new Solution();
        int result = solution.minMutation(start, end, bank);
        System.out.println(result); // Expected output: 1
    }
}

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> s = new HashSet<>();
        for (String b : bank) {
            s.add(b);
        }
        Map<Character, String> mp = new HashMap<>(4);
        mp.put('A', "TCG");
        mp.put('T', "ACG");
        mp.put('C', "ATG");
        Deque<AbstractMap.SimpleEntry<String, Integer>> q = new LinkedList<>();
        q.offer(new AbstractMap.SimpleEntry<>(start, 0));
        while (!q.isEmpty()) {
            AbstractMap.SimpleEntry<String, Integer> p = q.poll();
            String t = p.getKey();
            int step = p.getValue();
            if (end.equals(t)) {
                return step;
            }
            for (int i = 0; i < t.length(); ++i) {
                for (char c : mp.get(t.charAt(i)).toCharArray()) {
                    String next = t.substring(0, i) + c + t.substring(i + 1);
                    if (s.contains(next)) {
                        q.offer(new AbstractMap.SimpleEntry<>(next, step + 1));
                        s.remove(next);
                    }
                }
            }
        }
        return -1;
    }
}