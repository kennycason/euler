package problems._016;

import lib.BigIntegers;
import main.Problem;
import main.annotations.Solved;

import java.math.BigInteger;

@Solved
public class _016 extends Problem {

	public static void main(String[] args) {
		Problem p = new _016();
		p.run();
		System.out.println(p.answer());
	}
	
	public void run() {
		int exp = 1000;
		BigInteger n = BigIntegers.pow(2, exp);
		String digits = n.toString();
		int sum = 0;
		for(int i = 0; i < digits.length(); i++) {
			sum += Integer.valueOf(String.valueOf((digits.charAt(i))));
		}
		this.answer = sum;
	}
	
}
