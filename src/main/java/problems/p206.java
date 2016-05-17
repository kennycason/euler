package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class p206 extends Problem {

    public static void main(String[] args) {
        Problem p = new p206();
        p.run();
        System.out.println(p.answer());
    }

    /**
     Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
     where each “_” is a single digit.

     notes:
     sqrt(n) ends in 0, then last digit of n  must be zero because 10 * 10 = 100, 40 * 40 == 1600, etc
     therefore both end digits MUST be 0, we can factor of 100 and multiply by 10 at the end.

     max number to iterate on is sqrt(1929394959697989990), post optimization sqrt(19293949596979899)
     */
    public p206() {
        solved(false);
    }

    public void run() {
        final int maxN = (int)Math.sqrt(19293949596979899L); // root with zeros 1389026623, withotu 138902662
        final int minN = (int)Math.sqrt(10203040506070809L); // 1010101010
        //System.out.println("[" + maxN + ".. " + minN + "]");
        for(int n = maxN; n > minN; n -= 1) {
            if(isConcealedSquare(n)) {
                this.answer = n * 10;
                return;
            }
        }
    }

    private boolean isConcealedSquare(long n) {
        int[] digits = Numbers.getDigits(n * n);
        if(digits.length < 17) { return false; }
        return digits[0] == 9
                && digits[2] == 8
                && digits[4] == 7
                && digits[6] == 6
                && digits[8] == 5
                && digits[10] == 4
                && digits[12] == 3
                && digits[14] == 2
                && digits[16] == 1;
    }


}
