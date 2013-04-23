package _045;


public class _045 {

	public static void main(String[] args) {
		new _045();
	}

	/**
	 * goal: solve for n = Ta + Pb + Hc / 3
	 *  40755 + 
	 * patterns:
	 * Tn=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
	 *    +2, +3, +4, ...
	 *    d/dn = (2n + 1)/2
	 *    d2/dn = 1
	 *    
	 * Pn=n(3n−1)/2 	1, 5, 12, 22, 35, ...
	 *    +4, +7, +10, +13, ...
	 *    d/dn = (6n - 1)/2 
	 *    d2/dn = 3
	 *    
	 * Hn=n(2n−1) 	  	1, 6, 15, 28, 45, ...
	 *    +5, +9, +13
	 *    d/dn = (4n - 1)
	 *    d2/dn = 4
	 */
	public _045() {
		long d2dt = 1;
		long d2dp = 3;
		long d2dh = 4;
		
		long d1dt = 1;
		long d1dp = 1;
		long d1dh = 1;
		
		long tphn = 0;
		long tn = tphn;
		long pn = tphn;
		long hn = tphn;
		
		for(long n = 40756; ; n++) {
			while(tn < n) {
				tn += d1dt;
				d1dt += d2dt;
			}
			while(pn < n) {
				pn += d1dp;
				d1dp += d2dp;
			}
			while(hn < n) {
				hn += d1dh;
				d1dh += d2dh;
			}
			
			if(tn == pn && pn == hn && hn == n) {
				System.out.println(n);
				break;
			}
		}
		
	}

}
