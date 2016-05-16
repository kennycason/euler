package lib.fn;

public class Term {

    protected double a;

    protected double power;

    /**
     * a*x^power
     * @param a
     * @param power
     */
    public Term(double a, double power) {
        this.a = a;
        this.power = power;
    }

    public Term(double a) {
        this(a, 0);
    }

    public double eval(double x) {
        if(power == 0) {
            return a;
        }
        return a * Math.pow(x, power);
    }

}
