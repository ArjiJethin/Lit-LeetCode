1class Fancy {
2
3    static final int MOD = 1000000007;
4    List<Integer> v;
5    List<Integer> a;
6    List<Integer> b;
7
8    public Fancy() {
9        v = new ArrayList<Integer>();
10        a = new ArrayList<Integer>();
11        b = new ArrayList<Integer>();
12        a.add(1);
13        b.add(0);
14    }
15
16    public void append(int val) {
17        v.add(val);
18        a.add(a.get(a.size() - 1));
19        b.add(b.get(b.size() - 1));
20    }
21
22    public void addAll(int inc) {
23        int bLastIndex = b.size() - 1;
24        int bLast = b.get(bLastIndex);
25        bLast = (bLast + inc) % MOD;
26        b.set(bLastIndex, bLast);
27    }
28
29    public void multAll(int m) {
30        int aLastIndex = a.size() - 1, bLastIndex = b.size() - 1;
31        int aLast = (int) (((long) a.get(aLastIndex) * m) % MOD);
32        a.set(aLastIndex, aLast);
33        int bLast = (int) (((long) b.get(bLastIndex) * m) % MOD);
34        b.set(bLastIndex, bLast);
35    }
36
37    public int getIndex(int idx) {
38        if (idx >= v.size()) {
39            return -1;
40        }
41        int ao = (int) (((long) inv(a.get(idx)) * a.get(a.size() - 1)) % MOD);
42        int bo = (int) (((long) b.get(b.size() - 1) -
43                ((long) b.get(idx) * ao) % MOD +
44                MOD) %
45            MOD);
46        int ans = (int) (((((long) ao * v.get(idx)) % MOD) + bo) % MOD);
47        return ans;
48    }
49
50    // fast exponentiation
51    private int quickmul(int x, int y) {
52        long ret = 1;
53        long cur = x;
54        while (y != 0) {
55            if ((y & 1) != 0) {
56                ret = (ret * cur) % MOD;
57            }
58            cur = (cur * cur) % MOD;
59            y >>= 1;
60        }
61        return (int) ret;
62    }
63
64    // multiplicative inverse
65    private int inv(int x) {
66        return quickmul(x, MOD - 2);
67    }
68}