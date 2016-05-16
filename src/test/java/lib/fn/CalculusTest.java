package lib.fn;

import org.junit.Test;

public class CalculusTest {

    @Test
    public void test() {
        Calculus c = new Calculus();

        Polynomial p = new Polynomial(new Term(6, 2), new Term(-11, 1), new Term(6));
        for(;;) {
            System.out.println(p);
            p = c.differentiate(p);
            if(p.terms().isEmpty()) {
                break;
            }
        }

        System.out.println();
        int i = 0;
        p = new Polynomial(new Term(6, 8), new Term(-11, 7), new Term(-1, 5), new Term(13, 3), new Term(6));
        for(;;) {
            System.out.println(p);
            p = c.differentiate(p);
            if(p.terms().isEmpty() || i >= 10) {
                break;
            }
            i++;
        }

        System.out.println();
        p = new Polynomial(new Term(6, 8), new Term(-11, 7), new Term(-1, 5), new Term(13, 3), new Term(6));
        i = 0;
        for(;;) {
            System.out.println(p);
            p = c.integrate(p);
            if(i >= 10) {
                break;
            }
            i++;
        }

    }

}
