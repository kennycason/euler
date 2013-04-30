package main;

public abstract class AbstractProblem implements Runnable {

	protected Object answer;
	
	private boolean solved; // In case I need to flag a mid-solved problem as not solved
	
	public AbstractProblem() {
		solved = true;
	}
	
	public Object answer() {
		return answer;
	}
	
	public abstract void run();
	
	public boolean solved() {
		return solved;
	}
	
	public void solved(boolean solved) {
		this.solved = solved;
	}
	
}
