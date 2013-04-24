package _049;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import lib.Numbers;
import lib.Sequence;


public class _049 {

	public static void main(String[] args) {
		new _049();
	}

	public _049() {
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
						System.out.println(perm + "" + (perm + 3330) + "" + (perm + 6660));
						return;
					}
				}
			}
			perms.clear();
		}
	}

}
