package lib.fn;

import java.util.LinkedList;
import java.util.List;

public class Polynomial {

	private List<Term> terms;
	
	public Polynomial(Term ... terms) {
		this.terms = new LinkedList<Term>();
		for(Term term : terms) {
			this.terms.add(term);
		}
	}
	
	public double eval(double x) {
		double value = 0;
		for(Term term : terms) {
			value += term.eval(x);
		}
		return value;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Term term : terms) {
			if(term.power == 1) {
				sb.append(term.a + "x ");
			} else if(term.power > 1) {
				sb.append(term.a + "x^" + term.power + " ");
			} else {
				sb.append(term.a + " ");
			}
		}
		return sb.toString().trim();
	}

	public List<Term> terms() {
		return terms;
	}
	
}
