package _124;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lib.Numbers;
import main.AbstractProblem;

public class _124 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _124();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		List<Container> containers = new LinkedList<Container>();
		for(int n = 1; n <= 100000; n++) {
			containers.add(new Container(n, rad(n)));
		}
		Collections.sort(containers);
		this.answer = containers.get(10000 - 1).n;
	}
	
	public int rad(int n) {
		List<Long> distPrimeFactors = Numbers.distinctPrimeFactors(n);
		int mult = 1;
		for(Long m : distPrimeFactors) {
			mult *= m;
		}
		return mult;
	}
	
	private class Container implements Comparable<Container> {
		
		int n;
		
		int rad;
		
		public Container(int n, int rad) {
			this.n = n;
			this.rad = rad;
		}

		@Override
		public int compareTo(Container c) {
			if(rad != c.rad) {
				if(rad < c.rad) {
					return -1;
				} else if(rad > c.rad) {
					return 1;
				}
				return 0;
			} else {
				if(n < c.n) {
					return -1;
				} else if(n > c.n) {
					return 1;
				}
				return 0;	
			}
		}
		
		public String toString() {
			return n + " " + rad;
		}
		
	}

}
