package problems._055;

import lib.BigIntegers;
import main.Problem;
import main.annotations.Solved;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

@Solved
public class _055 extends Problem {

	public static void main(String[] args) {
		Problem p = new _055();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		long count = 0;
		long limit = 10000;
		for(long i = 10; i < limit; i++) {
			boolean cycleFound = false;
			List<BigInteger> ns = new LinkedList<BigInteger>();
			BigInteger n = BigInteger.valueOf(i);
			for(long j = 0; j < 50; j++) {
				BigInteger r = BigIntegers.reverse(n);
				ns.add(n);
				BigInteger sum = n.add(r);
				if(BigIntegers.isPalindrome(sum)) {
					ns.add(sum);
					cycleFound = true;
					break;
				}
				n = sum;
			}
			if(!cycleFound) {
				count++;
			}
		}
		this.answer = count;
	}
	
}
