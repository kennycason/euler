package _040;

import main.AbstractProblem;




public class _040 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _040();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
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
		this.answer = product;
	}

}
