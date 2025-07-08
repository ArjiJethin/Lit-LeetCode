import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Problem288 {
    public static void main(String[] args) {
        // Example usage
        String[] dictionary = { "deer", "door", "cake", "card" };
        ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
        System.out.println(vwa.isUnique("dear")); // Expected output: true
        System.out.println(vwa.isUnique("cart")); // Expected output: false
        System.out.println(vwa.isUnique("cane")); // Expected output: true
        System.out.println(vwa.isUnique("make")); // Expected output: true
    }
}

class ValidWordAbbr {
    private Map<String, Set<String>> d = new HashMap<>();

    @SuppressWarnings("unused")
    public ValidWordAbbr(String[] dictionary) {
        for (var s : dictionary) {
            d.computeIfAbsent(abbr(s), k -> new HashSet<>()).add(s);
        }
    }

    public boolean isUnique(String word) {
        var ws = d.get(abbr(word));
        return ws == null || (ws.size() == 1 && ws.contains(word));
    }

    private String abbr(String s) {
        int n = s.length();
        return n < 3 ? s : s.substring(0, 1) + (n - 2) + s.substring(n - 1);
    }
}