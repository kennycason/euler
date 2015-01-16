package problems._079;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Solved
public class _079 extends Problem {

	public static void main(String[] args) {
		Problem p = new _079();
		p.run();
		System.out.println(p.answer());
	}

    // brute force
	public void run() {
//        final List<int[]> allDigits1 = Arrays.asList(new int[] {1,2,3}, new int[] {2,3,4});
//        System.out.println(matchesAll(1234, allDigits1));
//        System.out.println(matchesAll(124, allDigits1));

        final List<int[]> allDigits = loadDigits();
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

    private List<int[]> loadDigits() {
        List<int[]> allDigits = new ArrayList<>();
        try {
            final List<String> lines = IOUtils.readLines(Thread.currentThread().getContextClassLoader().getResourceAsStream("problems/_079/keylog.txt"));
            for(String line : lines) {
                final long n = Integer.parseInt(line);  // no zeros in file, so this is safe
                final int[] digits = Numbers.getDigits(n);
                ArrayUtils.reverse(digits);
                allDigits.add(digits);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allDigits;
    }
	
}
