import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class Problem218 {

    public static void main(String[] args) {

        Solution_Heap s = new Solution_Heap();

        // output: [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]
        s.getSkyline(new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } })
                .stream().forEach(System.out::println);
    }

    static class Solution_Heap {

        public List<List<Integer>> getSkyline(int[][] buildings) {

            List<List<Integer>> result = new ArrayList<>();

            if (buildings == null || buildings.length == 0
                    || buildings[0].length == 0) {
                return result;
            }

            List<Edge> edges = new ArrayList<Edge>();

            // add all left/right edges
            for (int[] each : buildings) {
                edges.add(new Edge(each[0], each[2], true));
                edges.add(new Edge(each[1], each[2], false));
            }

            // sort edges, NlogN
            Collections.sort(edges, (a, b) -> {
                if (a.x != b.x) {
                    return Integer.compare(a.x, b.x);
                }

                if (a.isStart && b.isStart) {
                    return Integer.compare(b.height, a.height); // higher edge at front
                }

                if (!a.isStart && !b.isStart) {
                    return Integer.compare(a.height, b.height); // lower edge at front
                }

                return a.isStart ? -1 : 1; // lower edge at front
            });

            // process edges, comparator is reverseOrder()
            PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

            for (Edge edge : edges) {

                if (edge.isStart) {

                    if (heightHeap.isEmpty() || edge.height > heightHeap.peek()) {
                        result.add(Arrays.asList(edge.x, edge.height));
                    }

                    heightHeap.add(edge.height);

                } else {

                    heightHeap.remove(edge.height);

                    if (heightHeap.isEmpty()) {
                        result.add(Arrays.asList(edge.x, 0)); // last point
                    } else if (edge.height > heightHeap.peek()) { // @note: intersect
                        result.add(Arrays.asList(edge.x, heightHeap.peek()));
                    }
                }
            }
            return result;
        }

        class Edge {
            int x; // x坐标
            int height;
            boolean isStart;

            public Edge(int x, int height, boolean isStart) {
                this.x = x;
                this.height = height;
                this.isStart = isStart;
            }
        }
    }

    // merge sort example
    public class Solution_mergeSort {

        public List<int[]> getSkyline(int[][] buildings) {

            if (buildings == null || buildings.length == 0) {
                return new LinkedList<int[]>();
            }

            return getSkyline(buildings, 0, buildings.length - 1);
        }

        // NlogN
        private LinkedList<int[]> getSkyline(int[][] buildings, int lo, int hi) {

            if (lo < hi) {

                int mid = lo + (hi - lo) / 2;
                return mergeSkylines(getSkyline(buildings, lo, mid), getSkyline(buildings, mid + 1, hi));

            } else {

                // lo == hi, base case, add the final already-merged building to skyline
                LinkedList<int[]> skyline = new LinkedList<int[]>();

                skyline.add(new int[] { buildings[lo][0], buildings[lo][2] }); // only care about [left-index, height]
                skyline.add(new int[] { buildings[lo][1], 0 }); // right-index is just for last right edge

                return skyline;
            }
        }

        // merge two Skylines
        private LinkedList<int[]> mergeSkylines(LinkedList<int[]> skyline1, LinkedList<int[]> skyline2) {

            LinkedList<int[]> skyline = new LinkedList<int[]>();
            int height1 = 0, height2 = 0;

            while (skyline1.size() > 0 && skyline2.size() > 0) {

                int index = 0, height = 0;

                // @note: always remove the smaller index first, so order is guaranteed
                if (skyline1.getFirst()[0] < skyline2.getFirst()[0]) {
                    index = skyline1.getFirst()[0];
                    height1 = skyline1.getFirst()[1];
                    height = Math.max(height1, height2);
                    skyline1.removeFirst();
                } else if (skyline1.getFirst()[0] > skyline2.getFirst()[0]) {
                    index = skyline2.getFirst()[0];
                    height2 = skyline2.getFirst()[1];
                    height = Math.max(height1, height2);
                    skyline2.removeFirst();
                } else {
                    index = skyline1.getFirst()[0];
                    height1 = skyline1.getFirst()[1];
                    height2 = skyline2.getFirst()[1];
                    height = Math.max(height1, height2);
                    skyline1.removeFirst();
                    skyline2.removeFirst();
                }

                if (skyline.size() == 0 || height != skyline.getLast()[1]) {
                    skyline.add(new int[] { index, height });
                }
            }

            // final check
            skyline.addAll(skyline1);
            skyline.addAll(skyline2);

            return skyline;
        }

    }

}