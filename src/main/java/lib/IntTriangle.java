package lib;

public class IntTriangle {

    private int height;

    private int numPoints;

    private int[][] triangle;

    public IntTriangle(int height) {
        this.height = height;
        triangle = new int[height][];
        for(int y = 0; y < height; y++) {
            triangle[y] = new int[y + 1];
        }
        numPoints = (int) Numbers.factorial(height);
    }

    public void setAll(int... values) {
        int i = 0;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < triangle[y].length; x++) {
                triangle[y][x] = values[i];
                i++;
            }
        }
    }

    public void set(int y, int x, int value) {
        triangle[y][x] = value;
    }

    public int get(int y, int x) {
        return triangle[y][x];
    }

    public int[] row(int y) {
        return triangle[y];
    }

    public int height() {
        return height;
    }

    public int numPoints() {
        return numPoints;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < triangle[y].length; x++) {
                sb.append(triangle[y][x] + "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
