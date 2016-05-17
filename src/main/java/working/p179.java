package working;

import lib.Numbers;
import main.Problem;

import java.util.List;

public class p179 extends Problem {

    public static void main(String[] args) {
        Problem p = new p179();
        p.run();
        System.out.println(p.answer());
    }

    public p179() {
        solved(false);
        // printTable(500); // cool little pattern i found :)
    }

    public void run() {
        int count = 0;
        int nDiv = Numbers.properDivisors(2).size();
        int n2Div;
        for(int n = 3; n < 10000000 - 1; n++) {
            n2Div = Numbers.properDivisors(n).size();
            if(nDiv == n2Div) {
                count++;
            }
            nDiv = n2Div;
        }
        this.answer = count;
    }

    public void printTable(int max) {
        for(int n = 2; n < max - 1; n++) {
            printRow(n, Numbers.properDivisors(n));
        }
    }

    private void printRow(int n, List<Long> properDivisors) {
        int i = 1;
        System.out.print(n + ":\t\t");
        for(Long d : properDivisors) {
            while(i < d) {
                System.out.print("\t");
                i++;
            }
            System.out.print(d);
        }
        System.out.println();
    }

}
