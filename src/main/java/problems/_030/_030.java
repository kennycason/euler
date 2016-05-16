package problems._030;

import main.Problem;
import main.annotations.Solved;

@Solved
public class _030 extends Problem {

    public static void main(String[] args) {
        Problem p = new _030();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int sum = 0;
        for(int i = 2; i < 250000; i++)  {
            if(match(i)) {
                sum += i;
            }
        }
        this.answer = sum;
    }


    private boolean match(int i) {
        int sum = 0;
        int orig = i;
        int digit;
        do {
            digit = i % 10;
            sum += digit * digit * digit * digit * digit;
            i /= 10;
        } while(i > 0);
        return orig == sum;
    }

}
