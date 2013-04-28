package _044;

import java.util.HashSet;
import java.util.Set;

import main.AbstractProblem;

public class _044 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _044();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		Set<Integer> ps = new HashSet<Integer>();
		for(int i = 1; i < 10000; i++) {
			ps.add(p(i));
		}
		for(int j = 1; j < 10000; j++) {
			for(int k = 1; k < 10000; k++) {
				int pj = p(j);
				int pk = p(k);
				if(ps.contains(pj + pk) && ps.contains(Math.abs(pk - pj))) {
					this.answer = Math.abs(pk - pj);
					return;
				}
			}	
		}
	}

	public int p(int n) {
		return n * (3 * n - 1) / 2;
	}
	
}
