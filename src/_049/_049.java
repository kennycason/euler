package _049;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import lib.Numbers;
import lib.Sequence;
import main.AbstractProblem;


public class _049 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _049();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		Set<Long> orig = Sequence.permutation(1487l);	
		List<Long> perms = new ArrayList<Long>();
		for(long n = 1000; n < 10000; n++) {
			if(orig.contains(n)) {
				continue;
			}
			Set<Long> permSet = Sequence.permutation(n);
			if(permSet.size() < 3) {
				continue;
			}
			perms.addAll(permSet);
			Collections.sort(perms);
			for(Long perm : perms) {
				if(perm < 1000 || !Numbers.isPrime(perm)) {
					continue;
				}
				if(perms.contains(perm + 3330) && perms.contains(perm + 6660)) {
					if(Numbers.isPrime(perm + 3330) && Numbers.isPrime(perm + 6660)) {
						this.answer = perm + "" + (perm + 3330) + "" + (perm + 6660);
						return;
					}
				}
			}
			perms.clear();
		}
	}

}
