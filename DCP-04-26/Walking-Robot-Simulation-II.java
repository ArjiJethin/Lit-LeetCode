1class Robot {
2
3    private boolean moved = false;
4    private int idx = 0;
5    private List<int[]> pos = new ArrayList<>();
6    private List<Integer> dir = new ArrayList<>();
7    private Map<Integer, String> toDir = new HashMap<>();
8
9    public Robot(int width, int height) {
10        toDir.put(0, "East");
11        toDir.put(1, "North");
12        toDir.put(2, "West");
13        toDir.put(3, "South");
14
15        for (int i = 0; i < width; ++i) {
16            pos.add(new int[] { i, 0 });
17            dir.add(0);
18        }
19        for (int i = 1; i < height; ++i) {
20            pos.add(new int[] { width - 1, i });
21            dir.add(1);
22        }
23        for (int i = width - 2; i >= 0; --i) {
24            pos.add(new int[] { i, height - 1 });
25            dir.add(2);
26        }
27        for (int i = height - 2; i > 0; --i) {
28            pos.add(new int[] { 0, i });
29            dir.add(3);
30        }
31        dir.set(0, 3);
32    }
33
34    public void step(int num) {
35        moved = true;
36        idx = (idx + num) % pos.size();
37    }
38
39    public int[] getPos() {
40        return pos.get(idx);
41    }
42
43    public String getDir() {
44        if (!moved) {
45            return "East";
46        }
47        return toDir.get(dir.get(idx));
48    }
49}