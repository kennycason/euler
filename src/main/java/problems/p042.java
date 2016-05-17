package problems;

import lib.FileReader;
import main.Problem;
import main.annotations.Solved;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Solved
public class p042 extends Problem {

    public static void main(String[] args) {
        Problem p = new p042();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        Map<String, Integer> words = loadFromFile("problems/_042/words.txt");
        int maxScore = getMaxWordScore(words);
        Set<Integer> triangleNumbers = generateTriangleNumbers(maxScore);
        int n = 0;
        for(Integer score : words.values()) {
            if(triangleNumbers.contains(score)) {
                n++;
            }
        }
        this.answer = n;
    }

    private Set<Integer> generateTriangleNumbers(int maxScore) {
        Set<Integer> set = new HashSet<Integer>();
        int i = 1;
        int n;
        for(;;) {
            n = triangleNumber(i);
            if(n >= maxScore) {
                break;
            }
            set.add(n);
            i++;
        }
        return set;
    }

    private int triangleNumber(int n) {
        return  n * (n + 1) / 2;
    }

    private int getMaxWordScore(Map<String, Integer> words) {
        int max = 0;
        for(Integer score : words.values()) {
            if(score > max) {
                max = score;
            }
        }
        return max;
    }

    private int charVal(char c) {
        return (int) c - 65 + 1;
    }

    private int wordScore(String word) {
        char[] cArr = word.toCharArray();
        int score = 0;
        for(char c : cArr) {
            score += charVal(c);
        }
        return score;
    }


    private Map<String, Integer> loadFromFile(String file) {
        Map<String, Integer> words = new HashMap<String, Integer>();
        FileReader reader = new FileReader(file);
        String content = reader.getContent();

        content = content.replaceAll("\"|\n", "");
        for(String word : content.split(",")) {
            words.put(word, wordScore(word));
        }
        return words;
    }

}
