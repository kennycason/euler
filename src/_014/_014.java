package _014;

import java.util.LinkedList;
import java.util.List;

import lib.Sequence;
import main.AbstractProblem;



public class _014 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _014();
		p.run();
		System.out.println(p.answer());
	}
	
	public void run() {
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
		this.answer = maxi;
	}
	
}
