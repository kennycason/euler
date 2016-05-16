package problems._047;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Solved
public class _047 extends Problem {

    public static void main(String[] args) {
        Problem p = new _047();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int consecutiveGoal = 4;
        int distinctPrimeFactorGoal = 4;

        int consecutive = 0;
        for(int i = 2; ; i++) {
            List<Long> factors =  Numbers.factors(i);
            if(onlyNDistinctPrimeFactors(factors, distinctPrimeFactorGoal)) {
                consecutive++;
            } else {
                consecutive = 0;
            }
            if(consecutive == consecutiveGoal) {
                this.answer = i - consecutiveGoal + 1;
                // System.out.println(factors);
                break;
            }
        }
    }

    private boolean onlyNDistinctPrimeFactors(List<Long> factors, int n) {
        Set<Long> set = new HashSet<Long>();
        for(Long factor : factors) {
            if(!Numbers.isPrime(factor)) {
                return false;
            }
            set.add(factor);
        }
        return set.size() == n;
    }

}
