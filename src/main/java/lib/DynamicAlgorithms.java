package lib;

public class DynamicAlgorithms {

    private DynamicAlgorithms() {
    }

    public static int getMaxPath(IntTriangle pathSums) {
        int max = Integer.MIN_VALUE;
        int y = pathSums.height() - 1;
        for(int x = 0; x < pathSums.height(); x++) {
            if(pathSums.get(y, x) > max) {
                max = pathSums.get(y, x);
            }
        }
        return max;
    }

    public static IntTriangle calculateMaxPaths(IntTriangle triangle) {
        IntTriangle pathSums = new IntTriangle(triangle.height());
        // init
        pathSums.set(0, 0, triangle.get(0, 0));

        // node1
        for(int y = 0; y < triangle.height() - 1; y++) {
            for(int x = 0; x < triangle.row(y).length; x++) {
                // node 2
                int val = pathSums.get(y, x) + triangle.get(y + 1, x);
                if(val > pathSums.get(y + 1, x)) {
                    pathSums.set(y + 1, x, val);
                }
                val = pathSums.get(y, x) + triangle.get(y + 1, x + 1);
                if(val > pathSums.get(y + 1, x + 1)) {
                    pathSums.set(y + 1, x + 1, val);
                }
            }
        }
        return pathSums;
    }

    public static long[] totientSums(int n) {
        long[] phi = Numbers.enumerate(0, n + 1);
        for(int i = 2; i <= n; i++){
            if (phi[i] == i) {
                for (int j = i; j <= n; j += i) {
                    phi[j] = phi[j] / i * (i - 1);
                }
            }
        }
        return phi;
    }

}
