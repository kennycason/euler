package lib;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Lexographic {


    public static List<String> enumerate(char[] alphabet) {
        return enumerate(new char[alphabet.length], 0, new BitSet(), alphabet);

    }

    private static List<String> enumerate(char[] l, int from, BitSet used, char[] alphabet) {
        List<String> enums = new ArrayList<String>();
        if (from == l.length) {
            enums.add(new String(l));
        } else {
            for (int i = 0; i < l.length; i++) {
                if (!used.get(i)) {
                    l[from] = alphabet[i];
                    used.set(i);
                    enums.addAll(enumerate(l, from + 1, used, alphabet));
                    used.clear(i);
                }
            }
        }
        return enums;
    }

    public static List<String> circle(String s) {
        List<String> circles = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++) {
            char[] cs = new char[s.length()];
            for(int off = 0; off <cs.length; off++) {
                cs[(i + off) % cs.length] = s.charAt(off % cs.length);
            }
            circles.add(new String(cs));
        }
        return circles;
    }

}
