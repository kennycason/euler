package _034;

import lib.Numbers;





public class _034 {

	public static void main(String[] args) {
		new _034();
	}

	public _034() {
		int sum = 0;
		for(int i = 3; i < 100000; i++) {
			if(digitsFactorialSum(i) == i) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	private long digitsFactorialSum(int i) {
		long sum = 0;
		while(i > 0) {
			sum += Numbers.factorial(i % 10);
			i /= 10;
		}
		return sum;
	}
	
	

}
