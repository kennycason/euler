package _039;



public class _039 {

	public static void main(String[] args) {
		new _039();
	}

	public _039() {
		int maxN = 0;
		int maxSoln = 0;
		
		double c;
		int numSoln;
		for(int n = 1; n <= 1000; n++) {
			numSoln = 0;
			for(int a = 1; a < n / 2; a++) {
				for(int b = a; b < n / 2; b++) {
					c = Math.sqrt(a * a + b * b);
					if(a + b + c == n) {
						numSoln++;
					}
				}
			}
			if(numSoln > maxSoln) {
				maxSoln = numSoln;
				maxN = n;
			}
		}
		System.out.println(maxN);
	}

}
