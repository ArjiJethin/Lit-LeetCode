public class Problem251 {
    public static void main(String[] args) {
        // Example usage
        int[][] vec = { { 1, 2 }, { 3 }, { 4, 5, 6 } };
        Vector2D vector2D = new Vector2D(vec);
        while (vector2D.hasNext()) {
            System.out.print(vector2D.next() + " ");
        }
        // Expected output: 1 2 3 4 5 6
    }
}

class Vector2D {
    private int i;
    private int j;
    private int[][] vec;

    public Vector2D(int[][] vec) {
        this.vec = vec;
    }

    public int next() {
        forward();
        return vec[i][j++];
    }

    public boolean hasNext() {
        forward();
        return i < vec.length;
    }

    private void forward() {
        while (i < vec.length && j >= vec[i].length) {
            ++i;
            j = 0;
        }
    }
}