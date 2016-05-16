package lib.fn;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolynomialTest {

    @Test
    public void test() {
        Polynomial p = new Polynomial(new Term(6, 2), new Term(-11, 1), new Term(6));
        assertEquals(1, p.eval(1), 0.0);
        assertEquals(8, p.eval(2), 0.0);
        assertEquals(27, p.eval(3), 0.0);
        assertEquals(58, p.eval(4), 0.0);

        p = new Polynomial(new Term(1, 3));
        assertEquals(1, p.eval(1), 0.0);
        assertEquals(8, p.eval(2), 0.0);
        assertEquals(27, p.eval(3), 0.0);
        assertEquals(64, p.eval(4), 0.0);
        assertEquals(125, p.eval(5), 0.0);

        p = new Polynomial(new Term(1), new Term(-1, 1), new Term(1, 2), new Term(-1, 3), new Term(1, 4), new Term(-1, 5),
                new Term(1, 6), new Term(-1, 7), new Term(1, 8), new Term(-1, 9), new Term(1, 10));

        for(int i = 1; i <= 4; i++) {
            System.out.println(i + ": " + p.eval(i));
        }
    }

}
