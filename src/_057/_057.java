package _057;

public class _057 {

	public static void main(String[] args) {
		new _057();
	}

	public _057() {
		for(int i = 0; i < 10; i++) {
			System.out.print("1");
			System.out.println(" = " + (1 + sqrt2(i)));
		}
	}

	private double sqrt2(int iter) {
		if(iter <= 0) {
			System.out.print(" + 1/2");
			return 0.5;
		}
		System.out.print(" + 1/(2 ");
		double v = sqrt2(--iter);
		v = 1 / (2 + v);
		System.out.print(")");
		return v;
	}
	
}
