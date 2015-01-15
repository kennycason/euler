package problems._074;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

import java.util.HashSet;
import java.util.Set;

@Solved
public class _074 extends Problem {

	public static void main(String[] args) {
		Problem p = new _074();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int count = 0;
		for(long i = 1; i < 1000000; i++) {
			long sum = sumFactorialOfDigits(Numbers.getDigits(i));
			Set<Long> chain = new HashSet<Long>();
			chain.add(i);
			while(!chain.contains(sum)) {
				chain.add(sum);
				sum = sumFactorialOfDigits(Numbers.getDigits(sum));
			}
			if(chain.size() == 60) {
				count++;
			}
		}
		this.answer = count;
	}
	
	private long sumFactorialOfDigits(int[] digits) {
		long sum = 0;
		for(Integer d : digits) {
			sum += Numbers.factorial(d);
		}
		return sum;
	}
}
