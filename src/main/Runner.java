package main;

import lib.Clock;

public class Runner {

	public static void main(String[] args) {
		Runner r = new Runner();
		r.run();
	}
	
	public void run() {

		Clock clock = Clock.getInstance();
		for(int i = 1; i < 500; i++) {
			try {
				Class<?> clazz = Class.forName("_" + pad(i) + "._" + pad(i));
			    System.out.println("Problem #" + i);
			    clock.start();
			    System.out.print("Answer: ");
			    clazz.newInstance();
				System.out.println("Time: " + clock.elapsedMillis() / 1000.0 + "s");
				clock.reset();
				System.out.println();
			} catch (Exception e) {
				// Pokemon, gotta catch'em all!
			} 
		}
	}

	private String pad(int i) {
		if(i < 10) {
			return "00" + i;
		}
		if(i < 100) {
			return "0" + i;
		}
		return String.valueOf(i);
	}
	
}
