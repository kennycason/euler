package _035;

import java.util.List;

import lib.Lexographic;
import lib.Numbers;


public class _035 {

	public static void main(String[] args) {
		new _035();
	}

	public _035() {
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
		System.out.println(num);
	}


}
