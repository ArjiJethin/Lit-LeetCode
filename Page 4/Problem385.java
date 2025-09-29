import java.util.Deque;
import java.util.ArrayDeque;

public class Problem385 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "[123,[456,[789]]]";
        NestedInteger result = solution.deserialize(s);
        System.out.println("Deserialized NestedInteger: " + result);
    }
}

class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> stk = new ArrayDeque<>();
        int x = 0;
        boolean neg = false;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '-') {
                neg = true;
            } else if (Character.isDigit(c)) {
                x = x * 10 + c - '0';
            } else if (c == '[') {
                stk.push(new NestedInteger());
            } else if (c == ',' || c == ']') {
                if (Character.isDigit(s.charAt(i - 1))) {
                    if (neg) {
                        x = -x;
                    }
                    stk.peek().add(new NestedInteger(x));
                }
                x = 0;
                neg = false;
                if (c == ']' && stk.size() > 1) {
                    NestedInteger t = stk.pop();
                    stk.peek().add(t);
                }
            }
        }
        return stk.peek();
    }
}

// Minimal implementation for NestedInteger
class NestedInteger {
    private Integer value;
    private java.util.List<NestedInteger> list;

    public NestedInteger() {
        this.list = new java.util.ArrayList<>();
    }

    public NestedInteger(int value) {
        this.value = value;
    }

    public boolean isInteger() {
        return value != null;
    }

    public Integer getInteger() {
        return value;
    }

    public void setInteger(int value) {
        this.value = value;
        this.list = null;
    }

    public void add(NestedInteger ni) {
        if (list == null) {
            list = new java.util.ArrayList<>();
        }
        list.add(ni);
    }

    public java.util.List<NestedInteger> getList() {
        return list;
    }

    @Override
    public String toString() {
        if (isInteger())
            return value.toString();
        return list.toString();
    }
}