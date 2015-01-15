package working._254;

import lib.Factorial;
import lib.Numbers;
import main.Problem;


public class _254 extends Problem {
	
	public static void main(String[] args) {
		Problem p = new _254();
		p.run();
		System.out.println(p.answer());
	}
	
	public _254() {
		solved(false);
	}

	// memoize
	//private Map<Long, Long> fMem = new HashMap<Long, Long>();
	//private Map<Long, Long> sfMem = new HashMap<Long, Long>();
	//private Map<Long, Long> gMem = new HashMap<Long, Long>();
	
	public void run() {
		// System.out.println(g(20)); // should be 267
	//	System.out.println(sumsg(1, 20)); // should be 156
	}
	
	public long sumsg(long start, long end) {
		long sum = 0;
		for(long n = start; n <= end; n++) {
			sum += sg(n);
		}
		return sum;
	}
	
	private long f(long n) {
		//if(fMem.containsKey(n)) {
		//	return fMem.get(n);
		//}
		long sum = 0;
		for(Integer d : Numbers.getDigits(n)) {
			sum += Factorial.FACTORIAL_TABLE[d];
		}
		//fMem.put(n, sum);
		return sum;
	}
	
	private long sf(long n) {
		//if(sfMem.containsKey(n)) {
		//	return sfMem.get(n);
		//}
		long sfn = Numbers.sum(Numbers.getDigits(f(n)));
		//sfMem.put(n, sfn);
		return sfn;
	}
	
	private long g(long i) {
		//if(gMem.containsKey(i)) {
		//	return gMem.get(i);
		//}
		for(long n = 1; ; n++) {
			if(sf(n) == i) {
		//		gMem.put(i, n);
				return n;
			}
		}
	}
	
	private long sg(long i) {
		return Numbers.sum(Numbers.getDigits(g(i)));
	}
	
}
