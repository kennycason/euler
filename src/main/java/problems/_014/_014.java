package problems._014;

import lib.Sequence;
import main.Problem;
import main.annotations.Solved;

import java.util.LinkedList;
import java.util.List;

@Solved
public class _014 extends Problem {

	public static void main(String[] args) {
		Problem p = new _014();
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
