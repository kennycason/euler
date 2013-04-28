package main;

public abstract class AbstractProblem implements Runnable {

	protected Object answer;
	
	public Object answer() {
		return answer;
	}
	
	public abstract void run();
	
}
