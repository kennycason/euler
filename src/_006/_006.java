package _006;

public class _006 {
	
	public static void main(String[] args) {
		new _006();
	}

	public _006() {
		int n = 100;
		System.out.println(squareOfSums(n) - sumOfSquares(n));
	}
	
	private long sumOfSquares(int n) {
		long sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i * i;
		}
		return sum;
	}

	private long squareOfSums(int n) {
		long sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum * sum;
	}
	
}
