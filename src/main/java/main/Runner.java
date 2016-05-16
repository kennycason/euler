package main;

import lib.Clock;
import lib.FileWriter;
import main.annotations.Solved;
import org.reflections.Reflections;

import java.awt.*;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {
        final Runner r = new Runner();
        r.run();
    }

    public void run() {

        final Clock clock = Clock.getInstance();
        clock.start();
        final Map<Integer, Problem> problems = Runner.getProblems();
        final List<Integer> keys = new LinkedList<Integer>(problems.keySet());
        Collections.sort(keys);

        final List<Result> results = new LinkedList<Result>();
        for(Integer i : keys) {
            try {
                Result r = new Result();
                r.problem = i;
                Problem p = problems.get(i);
                if(p.solved()) {
                    System.out.println("Problem #" + i);
                    clock.reset();
                    p.run();
                    r.answer = p.answer();
                    System.out.println("Answer: " + p.answer());
                    r.time = clock.elapsedMillis() / 1000.0;
                    System.out.println("Time: " + r.time + "s");
                    System.out.println();
                }
                if(p.solved()) {
                    results.add(r);
                }
            } catch (Exception e) {
                // Pokemon, gotta catch'em all!
            }
        }

        final FileWriter writer = new FileWriter("README.md");
        writer.write(buildHtml(results));
    }

    public static Map<Integer, Problem> getProblems() {
        final Map<Integer, Problem> problems = new HashMap<>();
        Reflections reflections = new Reflections("problems");
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Solved.class);
        for(Class<?> annotatedClass : annotatedClasses) {
            final int problemNumber = Integer.parseInt(annotatedClass.getSimpleName().replace("_", ""));
            try {
                problems.put(problemNumber, (Problem) annotatedClass.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return problems;
    }

    private String buildHtml(List<Result> results) {
        StringBuffer sb = new StringBuffer();
        sb.append("Project Euler - Java\n"
                + "=====\n\n"
                + "My attempt at Project Euler problems using Java<br/>\n"
                + "Friend Id: 51224783162534_6a549f720ff34f6884df595acdc8e85b<br/>\n"
                + "<img src=\"http://projecteuler.net/profile/kennycason.png?id=" + new Date().getTime() + "\"/><br/>\n"
                + "System Stats:\n"
                + "Available processors (cores): " +  Runtime.getRuntime().availableProcessors() + "\n"
                + "Max Memory: " + Runtime.getRuntime().maxMemory() + "<br/>\n"
                + "Current results (better view at: http://ken-soft.com/project-euler/)<br/>\n");
        sb.append("<table border=\"1\" cellpadding=\"4\">\n<tr><td></td><td>Answer</td><td>Time</td><td>@Source</td</tr>\n");
        for (Result r : results) {

            String url = "https://github.com/kennycason/euler/blob/master/src/main/java/problems/_" + pad(r.problem) + "/_" + pad(r.problem) + ".java";

            sb.append("<tr><td><b>");
            sb.append("#" + r.problem);
            sb.append("</b></td><td>");
            sb.append(r.answer);
            sb.append("</td><td style=\"background-color:#"
                    + toHex(scaleRedGreen(r.time, 2.0)) + "\">");
            sb.append(r.time + "s");
            sb.append("</td><td>");
            sb.append("<a href=\"" + url + "\" target=\"_blank\" style=\"text-decoration: none; color: black;\">Link</a>");
            sb.append("</td></tr>\n");
        }
        sb.append("</table>");
        return sb.toString();
    }

    private String pad(int i) {
        if (i < 10) {
            return "00" + i;
        }
        if (i < 100) {
            return "0" + i;
        }
        return String.valueOf(i);
    }

    private Color scaleRedGreen(double val, double max) {
        if(val < 0) {
            return Color.lightGray;
        }
        if(val > max) {
            val = max;
        }
        int r = (int) ((255 * (max - val)) / max);
        int g = (int) ((255 * val) / max);
        return new Color(255 - r, 255 - g, 0);
    }

    public String toHex(Color c) {
        String hexString = Integer.toHexString(c.getRGB() & 0xffffff);
        while (hexString.length() < 6) {
            hexString = "0" + hexString;
        }
        return hexString;
    }

    private class Result {

        public int problem;

        public Object answer;

        public double time;

        public String toString() {
            return "Problem #" + problem + " Answer:" + answer + " Time: "
                    + time + "s";
        }

    }
}
