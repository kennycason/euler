package problems._062;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

import java.util.HashMap;
import java.util.Map;

@Solved
public class _062 extends Problem {

    // map the largest or smallest? permutation of number to the number of cubes,
    // Is there is a better way to group numbers?
    // value Long[] {count, first cube(should be smallest)}
    private Map<Long, Long[]> cubeCount = new HashMap<Long, Long[]>();

    public static void main(String[] args) {
        Problem p = new _062();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        // System.out.println(largestPerm(10223456));
        // System.out.println(1028*1028*1028L);
        long cubed;
        long largest;
        for(long n = 1; ; n++) {
            if(n > 10000) {
                break;
            }
            cubed = n * n * n;
            largest = largestPerm(cubed);
            if(!cubeCount.containsKey(largest)) {
                Long[] val = new Long[] {1L, cubed};
                cubeCount.put(largest, val);
            } else {
                Long[] val = cubeCount.get(largest);
                val[0]++;
                cubeCount.put(largest, val);
                if(cubeCount.get(largest)[0] == 5) {
                    this.answer = cubeCount.get(largest)[1];
                    return;
                }
            }
//            if(cubed == 41063625 || cubed == 56623104 || cubed == 66430125) {
//                System.out.println(n + " " + cubed + ", largest: " + largest);
//            }
        }
    }

    private long largestPerm(long n) {
        int reversed = 0;
        int digits = Numbers.numDigits(n);
        for(int d = 9; d >= 0; d--) {
            long c = n; // make copy
            for(int i = 0; i < digits; i++) {
                if(c % 10 == d) {
                    reversed *= 10;
                    reversed += d;
                }
                c /= 10;
            }
        }
        return reversed;
    }

}
