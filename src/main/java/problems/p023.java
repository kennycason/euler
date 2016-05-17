package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Solved
public class p023 extends Problem {

    public static void main(String[] args) {
        Problem p = new p023();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        List<Long> abundants = new LinkedList<Long>();
        for(long i = 12; i <= 28123; i++) {
            if(Numbers.isAbundant(i)) {
                abundants.add(i);
            }
        }
        // System.out.println(abundants.size());
        // System.out.println(abundants);

        HashSet<Long> canSum = new HashSet<Long>();

        for(long a : abundants) {
            for(long b : abundants) {
                canSum.add(a + b);
            }
        }

        int sum = 0;
        for(long i = 1; i <= 28123; i++) {
            if(!canSum.contains(i)) {
                sum += i;
            }
        }
        this.answer = sum;
    }

}
