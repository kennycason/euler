package problems._092;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

import java.util.HashSet;
import java.util.Set;

@Solved
public class _092 extends Problem {

	public static void main(String[] args) {
		Problem p = new _092();
		p.run();
		System.out.println(p.answer());
	}

    private final Set<Integer> endsAt1 = new HashSet<>();
    private final Set<Integer> endsAt89 = new HashSet<>();
    private int numEnd89Cycles = 0;

	public void run() {
        for(int i = 1; i < 10_000_000; i++) {
            cycle(i);
        }
        this.answer = numEnd89Cycles;
	}

    private void cycle(int start) {
        //System.out.print(start);
        int i = start;
        for(;;) {
            if(endsAt1.contains(i) || i == 1) {
                //System.out.println("... -> 1");
                endsAt1.add(start);
                return;
            }
            if(endsAt1.contains(i) || i == 89) {
                //System.out.println("... -> 89");
                endsAt89.add(start);
                numEnd89Cycles++;
                return;
            }
            i = nextCycle(i);
            //System.out.print(" -> " + i);
        }
    }

    private int nextCycle(final int i) {
        final int[] digits = Numbers.getDigits(i);
        int sum = 0;
        for(int digit : digits) {
            sum += digit * digit;
        }
        return sum;
    }


}
