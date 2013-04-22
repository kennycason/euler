package _030;




public class _030 {

	public static void main(String[] args) {
		new _030();
	}

	public _030() {
		int sum = 0;
		for(int i = 2; i < 250000; i++)  {
			if(match(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
	
	private boolean match(int i) {
		int sum = 0;
		int orig = i;
		int digit;
		do {
			digit = i % 10;
			sum += digit * digit * digit * digit * digit;
			i /= 10;
		} while(i > 0);
		return orig == sum;
	}

}
