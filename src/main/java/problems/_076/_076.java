package problems._076;

import main.Problem;
import main.annotations.Solved;

@Solved
public class _076 extends Problem {

    public static void main(String[] args) {
        Problem p = new _076();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int n = 100;
        // simply calculate all possibilities, iteratively giving & taking, much like #31
        int[] combinations = new int[n + 1];
        combinations[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j <= n; j++) {
                combinations[j] += combinations[j - i];
            }
        }
        /*
         *  tried with minus 1, (to make base case 5 work, not sure why it's off by one :/
         *  will have to examine later
         */
        this.answer = combinations[n];
    }

}
