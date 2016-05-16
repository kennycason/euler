package problems._020;

import lib.BigIntegers;
import main.Problem;
import main.annotations.Solved;

import java.math.BigInteger;

@Solved
public class _020 extends Problem {

    public static void main(String[] args) {
        Problem p = new _020();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int sum = 0;
        BigInteger n = BigIntegers.factorial(100);
        for(String d : n.toString().split("(?!^)")) {
            sum += Integer.parseInt(d);
        }
        this.answer = sum;
    }

}
