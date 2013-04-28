package _035;

import java.util.List;

import lib.Lexographic;
import lib.Numbers;
import main.AbstractProblem;


public class _035 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _035();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		List<Long> primes = Numbers.primes(999999);
		int num = 0;
		boolean allPrime = true;
		for(Long prime : primes) {
			List<String> circles = Lexographic.circle(String.valueOf(prime));
			allPrime = true;
			for(String circle : circles) {
				if(!Numbers.isPrime(Long.parseLong(circle))) {
					allPrime = false;
					break;
				}
			}
			if(allPrime) {
				num++;
			}
		}
		this.answer = num;
	}

}
