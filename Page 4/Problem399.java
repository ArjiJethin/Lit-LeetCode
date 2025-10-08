import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Problem399 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> equations = List.of(
                List.of("a", "b"),
                List.of("b", "c"));
        double[] values = { 2.0, 3.0 };
        List<List<String>> queries = List.of(
                List.of("a", "c"),
                List.of("b", "a"),
                List.of("a", "e"),
                List.of("a", "a"),
                List.of("x", "x"));
        double[] results = solution.calcEquation(equations, values, queries);
        for (double result : results) {
            System.out.println(result);
        }
    }
}

class Solution {
    private Map<String, String> p;
    private Map<String, Double> w;

    public double[] calcEquation(
            List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        p = new HashMap<>();
        w = new HashMap<>();
        for (List<String> e : equations) {
            p.put(e.get(0), e.get(0));
            p.put(e.get(1), e.get(1));
            w.put(e.get(0), 1.0);
            w.put(e.get(1), 1.0);
        }
        for (int i = 0; i < n; ++i) {
            List<String> e = equations.get(i);
            String a = e.get(0), b = e.get(1);
            String pa = find(a), pb = find(b);
            if (Objects.equals(pa, pb)) {
                continue;
            }
            p.put(pa, pb);
            w.put(pa, w.get(b) * values[i] / w.get(a));
        }
        int m = queries.size();
        double[] ans = new double[m];
        for (int i = 0; i < m; ++i) {
            String c = queries.get(i).get(0), d = queries.get(i).get(1);
            ans[i] = !p.containsKey(c) || !p.containsKey(d) || !Objects.equals(find(c), find(d))
                    ? -1.0
                    : w.get(c) / w.get(d);
        }
        return ans;
    }

    private String find(String x) {
        if (!Objects.equals(p.get(x), x)) {
            String origin = p.get(x);
            p.put(x, find(p.get(x)));
            w.put(x, w.get(x) * w.get(origin));
        }
        return p.get(x);
    }
}