package problems;

import lib.Sequence;
import main.Problem;
import main.annotations.Solved;

import java.util.BitSet;
import java.util.Set;

@Solved
public class p052 extends Problem {

    public static void main(String[] args) {
        Problem p = new p052();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int n1, n2, n3, n4, n5;
        for(int x = 1; ; x++) {
            n1 = 2 * x;
            n2 = 3 * x;
            n3 = 4 * x;
            n4 = 5 * x;
            n5 = 6 * x;

            BitSet set = new BitSet();
            while(n1 > 0) {
                set.set(n1 % 10);
                n1 /= 10;
            }
            // all n2,n3,n4,n5 should be same digit length,
            // so only need to check one of them
            boolean match = true;
            while(n2 > 0) {
                if(!set.get(n2 % 10)
                        || !set.get(n3 % 10)
                        || !set.get(n4 % 10)
                        || !set.get(n5 % 10)) {
                    match = false;
                    break;
                }
                n2 /= 10;
                n3 /= 10;
                n4 /= 10;
                n5 /= 10;
            }
            if(match) {
                this.answer = x;
                break;
            }
        }
    }


    public void bruteForce1() {
        long n1, n2, n3, n4, n5;
        for(long x = 1; ; x++) {
            n1 = 2 * x;
            n2 = 3 * x;
            n3 = 4 * x;
            n4 = 5 * x;
            n5 = 6 * x;
            Set<Long> set = Sequence.permutation(n1);
            if(!set.contains(n2)) {
                continue;
            }
            if(!set.contains(n3)) {
                continue;
            }
            if(!set.contains(n4)) {
                continue;
            }
            if(!set.contains(n5)) {
                continue;
            }
            this.answer = x;
            break;
        }
    }

}
