package lib.fn;

import java.util.Iterator;

public class Calculus {

    public Polynomial differentiate(Polynomial p) {
        Iterator<Term> iter = p.terms().iterator();
        while(iter.hasNext()) {
            Term t = iter.next();
            if(t.power == 0) {
                iter.remove();
            } else {
                t.a *= t.power;
                t.power -= 1;
            }
        }
        return p;
    }

    public Polynomial integrate(Polynomial p) {
        Iterator<Term> iter = p.terms().iterator();
        while(iter.hasNext()) {
            Term t = iter.next();
            t.a /= (t.power + 1);
            t.power += 1;
        }
        return p;
    }

}
