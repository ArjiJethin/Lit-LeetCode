import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Problem341 {
    public static void main(String[] args) {
        // Example usage
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger(1));
        nestedList.add(new NestedInteger(Arrays.asList(new NestedInteger(2), new NestedInteger(3))));
        nestedList.add(new NestedInteger(4));

        NestedIterator iterator = new NestedIterator(nestedList);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

class NestedIterator implements Iterator<Integer> {

    private List<Integer> vals;

    private Iterator<Integer> cur;

    public NestedIterator(List<NestedInteger> nestedList) {
        vals = new ArrayList<>();
        dfs(nestedList);
        cur = vals.iterator();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger e : nestedList) {
            if (e.isInteger()) {
                vals.add(e.getInteger());
            } else {
                dfs(e.getList());
            }
        }
    }
}