package _040;




public class _040 {

	public static void main(String[] args) {
		new _040();
	}

	public _040() {
		StringBuffer sb = new StringBuffer();
		int i = 1;
		while(sb.length() < 1000000) {
			sb.append(i);
			i++;
		}
		String n = sb.toString();
		int product = 1;
		for(int p = 1; p <= 1000000; p *= 10) {
			product *= Integer.parseInt(String.valueOf(n.charAt(p - 1)));
		}
		System.out.println(product);
	}

}
