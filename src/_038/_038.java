package _038;

import lib.Numbers;


public class _038 {

	public static void main(String[] args) {
		new _038();
	}

	public _038() {
		long num, max = 918273645;
		// highest value given in demo
		
		for(int i = 1; i < 9999; i++) {
			StringBuffer sb = new StringBuffer();
			for(int n = 1; n <= 9; n++) {
				sb.append(String.valueOf(i * n));
				
				String nStr = sb.toString();
				if(nStr.length() > 9) {
					break;
				}
				num = Long.parseLong(nStr);
				if(Numbers.is1To9PanDigit((int)num)) {
					// System.out.println(i + " x " + n + ": " + num);
					if(num > max) {
						max = num;
					}
				}
			}
		}
		System.out.println(max);
	}

}
