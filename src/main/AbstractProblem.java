package main;

public abstract class AbstractProblem implements Runnable {

	protected Object answer;
	
	protected boolean solved = true; // In case I need to flag a mid-solved problem as not solved
	
	public Object answer() {
		return answer;
	}
	
	public abstract void run();
	
	public boolean solved() {
		return solved;
	}
	
}
