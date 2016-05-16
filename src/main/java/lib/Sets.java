package lib;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    private Sets() {
    }

    public static Set<Number> intersection(Set<Number> a, Set<Number> b) {
        boolean set1IsLarger = a.size() > b.size();
        Set<Number> cloneSet = new HashSet<Number>(set1IsLarger ? b : a);
        cloneSet.retainAll(set1IsLarger ? a : b);
        return cloneSet;
    }

}
