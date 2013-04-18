package _012;



public class _012 {
	
	public static void main(String[] args) {
		new _012();
	}

	/** 
	 * brute force
	 * 	
	 * TODO  the number of divisors D(N) of any integer N can be computed from: 
	 * D(N) = (a1 + 1) * (a2 + 1) * ...
	 * D(28) = (2+1) * (1+1) = 3 * 2 = 6 
	 *  + prime number lookup array
	 */
	public _012() {
		int numDivisors = 500;
		
		int triangle = 1;
		int a = 1;
		int divisors = 0;
		while(divisors < numDivisors) {
			divisors = 0;
			a += 1;
			triangle = triangle + a;
			int root = (int)Math.sqrt(triangle);
			for(int i = 1; i < root; i++) {
				if(triangle % i == 0) {
					divisors += 2;
				}
			}
			if(triangle == root * root) { // correct for perfect squares
				divisors--;
			}
		}
		System.out.println(triangle);
		
	}
	 
}
