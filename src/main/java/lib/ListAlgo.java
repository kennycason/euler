package lib;

import java.util.List;

public class ListAlgo {

	private ListAlgo() {
	}
	
	public static Long max(List<Long> list) {
		long max = Long.MIN_VALUE;
		for(Long i : list) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}
	
	public static Long min(List<Long> list) {
		long min = Long.MAX_VALUE;
		for(Long i : list) {
			if(i < min) {
				min = i;
			}
		}
		return min;
	}

}
