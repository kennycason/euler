package _001;

public class _001 {

	public static void main(String[] args) {
		new _001();
	}

	public _001() {
		int max = 1000;
		
		int sum = 0;
		for(int i = 1; i < max; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
}
