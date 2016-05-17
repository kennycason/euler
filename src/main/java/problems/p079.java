package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

@Solved
public class p079 extends Problem {

    public static void main(String[] args) {
        Problem p = new p079();
        p.run();
        System.out.println(p.answer());
    }

    // brute force
    public void run() {
//        final List<int[]> allDigits1 = Arrays.asList(new int[] {1,2,3}, new int[] {2,3,4});
//        System.out.println(matchesAll(1234, allDigits1));
//        System.out.println(matchesAll(124, allDigits1));

        final List<int[]> allDigits = loadKeyDigits();
        int n = 101;
        for(;;) {
            if(matchesAll(n, allDigits)) {
                this.answer = n;
                return;
            }
            n++;
        }
    }

    private boolean matchesAll(final int n, final List<int[]> allDigits) {
        final int[] nDigits = Numbers.getDigits(n);
        ArrayUtils.reverse(nDigits);
        //System.out.println("N: " + Numbers.join(nDigits));
        for(int[] digits : allDigits) {
            //System.out.println("\t" + Numbers.join(digits));
            int lastI = 0;
            boolean digitsMatched = false;
            for(int j = 0; j < digits.length; j++) {
                for(int i = lastI; i <= nDigits.length; i++) {
                    if(i == nDigits.length) { return false; }
                    //System.out.println("d[" + i + "]=" + nDigits[i] + ", d[" + j + "]=" + digits[j]);
                    if(nDigits[i] == digits[j]) {
                        if(j == digits.length - 1) {
                            digitsMatched = true;
                            break;
                        }
                        lastI = i;
                        break;
                    }
                }
                if(digitsMatched) {
                    break;
                }
            }
        }
        return true;
    }

    private List<int[]> loadKeyDigits() {
        final int[] allKeys = new int[] {
                319,
                680,
                180,
                690,
                129,
                620,
                762,
                689,
                762,
                318,
                368,
                710,
                720,
                710,
                629,
                168,
                160,
                689,
                716,
                731,
                736,
                729,
                316,
                729,
                729,
                710,
                769,
                290,
                719,
                680,
                318,
                389,
                162,
                289,
                162,
                718,
                729,
                319,
                790,
                680,
                890,
                362,
                319,
                760,
                316,
                729,
                380,
                319,
                728,
                716
        };
        List<int[]> allDigits = new ArrayList<>();
        for(int pin : allKeys) {
            final int[] digits = Numbers.getDigits(pin);
            ArrayUtils.reverse(digits);
            allDigits.add(digits);
        }
        return allDigits;
    }

}
