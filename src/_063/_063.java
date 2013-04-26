package _063;



public class _063 {

	public static void main(String[] args) {
		new _063();
	}

	public _063() {
		int count = 0;
		for(int b = 1; b < 10; b++) {
			for(int p = 1; p < 25; p++) {
				double n = Math.pow(b, p);
				int digits = (int) Math.log10(n) + 1;
				if(p > digits) {
					break;
				}
				if(digits == p) {
					count++;
				}
			}		
		}
		System.out.println(count);
	}

}
