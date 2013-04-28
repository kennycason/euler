package _029;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import main.AbstractProblem;



public class _029 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _029();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		HashSet<Double> comb = combinations(2, 100);
		List<Double> combset = new LinkedList<Double>();
		combset.addAll(comb);
		Collections.sort(combset);
		this.answer = combset.size();
	}
	
	
	private HashSet<Double> combinations(int min, int max) {
		HashSet<Double> comb = new HashSet<Double>();
		for(int a = min; a <= max; a++) {
			for(int b = min; b <= max; b++) {
				comb.add(Math.pow(a, b));
			}	
		}
		return comb;
	}

}
