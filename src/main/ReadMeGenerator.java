package main;

import java.awt.Color;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lib.Clock;
import lib.FileWriter;

public class ReadMeGenerator {

	public static void main(String[] args) {
		ReadMeGenerator r = new ReadMeGenerator();
		r.run();
	}

	public void run() {
		PrintStream out = System.out;

		try {
			Clock clock = Clock.getInstance();
			List<Result> results = new LinkedList<Result>();

			// capture System.out
			PipedOutputStream pipeOut = new PipedOutputStream();
			PipedInputStream pipeIn = new PipedInputStream(pipeOut);
			System.setOut(new PrintStream(pipeOut));
			
			Map<Integer, Class<?>> problems = Runner.getProblems();
			List<Integer> keys = new LinkedList<Integer>(problems.keySet());
			Collections.sort(keys);
			
			for(Integer key : keys) {
				Class<?> p = problems.get(key);

				Result r = new Result();
				r.problem = key;
				
				if (p == null) {
					continue;
				}
				clock.start();
				p.newInstance();

				r.time = clock.elapsedMillis() / 1000.0;

				byte[] buffer = new byte[pipeIn.available()];
				pipeIn.read(buffer);
				r.answer = new String(buffer).replace("\n", "");

				r.time = clock.elapsedMillis() / 1000.0;

				clock.reset();
				results.add(r);

			}

			pipeIn.close();
			System.setOut(out);
			System.out.println("Writing README.md file");
			FileWriter writer = new FileWriter("README.md");
			writer.write(buildHtml(results));

		} catch (Exception e) {
			// Pokemon, gotta catch'em all!
			e.printStackTrace();
		}
	}

	private String buildHtml(List<Result> results) {
		StringBuffer sb = new StringBuffer();
		sb.append("Project Euler - Java\n"
				+ "=====\n\n"
				+ "My attempt at Project Euler problems using Java<br/>\n"
				+ "<img src=\"http://projecteuler.net/profile/kennycason.png?id=1\"/>\n\n"
				+ "Current results (better view at: http://ken-soft.com/project-euler/)<br/>\n");
		sb.append("<table border=\"1\" cellpadding=\"4\">\n<tr><td></td><td>Answer</td><td>Time</td><td>@Source</td</tr>\n");
		for (Result r : results) {
			
			String url = "https://github.com/kennycason/euler/blob/master/src/_" + pad(r.problem) + "/_" + pad(r.problem) + ".java";
			
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

		public String answer;

		public double time;

		public String toString() {
			return "Problem #" + problem + " Answer:" + answer + " Time: "
					+ time + "s";
		}

	}

}
