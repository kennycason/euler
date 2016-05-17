package problems;

import lib.FileReader;
import main.Problem;
import main.annotations.Solved;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Solved
public class p022 extends Problem {

    public static void main(String[] args) {
        Problem p = new p022();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        List<String> names = loadFromFile("problems/_022/names.txt");
        Collections.sort(names);
        long sum = 0;
        int i = 1;
        for(String name : names) {
            sum += (i * score(name));
            // System.out.println(i + ": " + name + " " + score(name) + " = " + i * score(name));
            i++;
        }
        this.answer = sum;
    }

    private int score(String name) {
        int score = 0;
        for(char c : name.toCharArray()) {
            score += c - 65 + 1;
        }
        return score;
    }

    private List<String> loadFromFile(String file) {
        FileReader reader = new FileReader(file);
        String content = reader.getContent();

        List<String> names = new LinkedList<String>();
        content = content.replaceAll("\"|\n", "");
        for(String name : content.split(",")) {
            names.add(name);
        }
        return names;
    }

}
