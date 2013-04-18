package _014;

import java.util.LinkedList;
import java.util.List;

import lib.Sequence;



public class _014 {
	
	
	public static void main(String[] args) {
		new _014();
	}

	public _014() {
		int n = 1000000;
		
		int maxi = -1;
		List<Long> maxSeq = new LinkedList<Long>();
		
		List<Long> seq;
		for(int i = 0; i < n; i++) {
			seq = Sequence.collatz(i);
			if(seq.size() > maxSeq.size()) {
				maxSeq = seq;
				maxi = i;
			}
		}
		//System.out.println(maxi + ": (" + maxSeq.size() + ") " + maxSeq);
		System.out.println(maxi);
	}
	
}
