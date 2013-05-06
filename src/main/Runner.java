package main;

import java.awt.Color;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lib.Clock;
import lib.FileWriter;
import _001._001;
import _002._002;
import _003._003;
import _004._004;
import _005._005;
import _006._006;
import _007._007;
import _008._008;
import _009._009;
import _010._010;
import _011._011;
import _012._012;
import _013._013;
import _014._014;
import _015._015;
import _016._016;
import _017._017;
import _018._018;
import _019._019;
import _020._020;
import _021._021;
import _022._022;
import _023._023;
import _024._024;
import _025._025;
import _026._026;
import _027._027;
import _028._028;
import _029._029;
import _030._030;
import _031._031;
import _032._032;
import _033._033;
import _034._034;
import _035._035;
import _036._036;
import _037._037;
import _038._038;
import _039._039;
import _040._040;
import _041._041;
import _042._042;
import _043._043;
import _044._044;
import _045._045;
import _046._046;
import _047._047;
import _048._048;
import _049._049;
import _050._050;
import _052._052;
import _053._053;
import _055._055;
import _056._056;
import _057._057;
import _058._058;
import _063._063;
import _067._067;
import _069._069;
import _071._071;
import _072._072;
import _073._073;
import _074._074;
import _097._097;
import _187._187;
import _214._214;
import _working._254._254;
import _working._283._283;

public class Runner {

	public static void main(String[] args) {
		Runner r = new Runner();
		r.run();
	}
	
	public void run() {
		
		Clock clock = Clock.getInstance();
		clock.start();
		Map<Integer, AbstractProblem> problems = Runner.getProblems();
		List<Integer> keys = new LinkedList<Integer>(problems.keySet());
		Collections.sort(keys);

		List<Result> results = new LinkedList<Result>();
		for(Integer i : keys) {
			try {
				Result r = new Result();
				r.problem = i;
				AbstractProblem p = problems.get(i);
				System.out.println(p.solved());
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
		
		FileWriter writer = new FileWriter("README.md");
		writer.write(buildHtml(results));

	}
	
	public static Map<Integer, AbstractProblem> getProblems() {
		Map<Integer, AbstractProblem> p = new HashMap<Integer, AbstractProblem>();
		p.put(1, new _001());
		p.put(2, new _002());
		p.put(3, new _003());
		p.put(4, new _004());
		p.put(5, new _005());
		p.put(6, new _006());
		p.put(7, new _007());
		p.put(8, new _008());
		p.put(9, new _009());
		p.put(10, new _010());
		p.put(11, new _011());
		p.put(12, new _012());
		p.put(13, new _013());
		p.put(14, new _014());
		p.put(15, new _015());
		p.put(16, new _016());
		p.put(17, new _017());
		p.put(18, new _018());
		p.put(19, new _019());
		p.put(20, new _020());
		p.put(21, new _021());
		p.put(22, new _022());
		p.put(23, new _023());
		p.put(24, new _024());
		p.put(25, new _025());
		p.put(26, new _026());
		p.put(27, new _027());
		p.put(28, new _028());
		p.put(29, new _029());
		p.put(30, new _030());
		p.put(31, new _031());
		p.put(32, new _032());
		p.put(33, new _033());
		p.put(34, new _034());
		p.put(35, new _035());
		p.put(36, new _036());
		p.put(37, new _037());
		p.put(38, new _038());
		p.put(39, new _039());
		p.put(40, new _040());
		p.put(41, new _041());
		p.put(42, new _042());
		p.put(43, new _043());
		p.put(44, new _044());
		p.put(45, new _045());
		p.put(46, new _046());
		p.put(47, new _047());
		p.put(48, new _048());
		p.put(49, new _049());
		p.put(50, new _050());
		p.put(52, new _052());
		p.put(53, new _053());
		p.put(55, new _055());
		p.put(56, new _056());
		p.put(57, new _057());
		p.put(58, new _058());
		p.put(63, new _063());	
		p.put(67, new _067());
		p.put(69, new _069());
		p.put(71, new _071());
		p.put(72, new _072());
		p.put(73, new _073());
		p.put(74, new _074());
		p.put(97, new _097());
		p.put(187, new _187());
		p.put(214, new _214());
		
		p.put(254, new _254());
		p.put(254, new _283());
		return p;
	}

	private String buildHtml(List<Result> results) {
		StringBuffer sb = new StringBuffer();
		sb.append("Project Euler - Java\n"
				+ "=====\n\n"
				+ "My attempt at Project Euler problems using Java<br/>\n"
				+ "System Stats:\n" 
				+ "Available processors (cores): " +  Runtime.getRuntime().availableProcessors() + "\n"
				+ "Max Memory: " + Runtime.getRuntime().maxMemory()
				+ "<img src=\"http://projecteuler.net/profile/kennycason.png?id=" + new Date().getTime() + "\"/>\n\n"
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
