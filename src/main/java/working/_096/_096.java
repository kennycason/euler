package working._096;

import lib.FileReader;
import main.Problem;

import java.util.LinkedList;
import java.util.List;

public class _096 extends Problem {

	public static void main(String[] args) {
		Problem p = new _096();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		List<State> states = solve(load());
		for(State state : states) {
			System.out.println(state);
		}
	}
	
	private List<State> solve(List<State> states) {
		List<State> solved = new LinkedList<>();
		
		Solver solver = new Solver();
		for(State state : states) {
			System.out.println(state);
			solved.add(solver.solve(state));
			break;
		}
		return solved;
	}
	
	
	private List<State> load() {
		FileReader reader = new FileReader("problems/_096/sudoku.txt");
		
		int r = 0;
		List<State> states = new LinkedList<>();
		State state = null;
		for(String line : reader.getContent().split("\n")) {
			if(line.startsWith("Grid")) {
				if(r == 9) {
					states.add(state);
				}
				r = 0;
				state = new State();
				continue;
			}
			int c = 0;
			for(String digit : line.split("")) {
				if(digit.equals("")) { continue; }
				state.state[r][c] = Integer.parseInt(digit);
				c++;
			}
			r++;
		}
		states.add(state);
		return states;
	}

	public static class Move {
		int x;
		int y;
		int val;
	}
	
	public static class Solver {
		
		private LinkedList<Move> moves = new LinkedList<>();
		
		public State solve(State state) {
			return state;
		}
		
	}
	
	public static class State {
	
		public int[][] state = new int[9][9];
		
		public boolean guessed = false;
		
		public State() {
			
		}
		
		public boolean isSolved() {
			for(int rc = 0; rc < 9; rc++) {
				if(!isRowSolved(rc)) { return false; }
				if(!isColSolved(rc)) { return false; }
			}
			return true;
		}
		
		public boolean isRowSolved(int r) {
			if(!isRowFull(r)) { return false; }
			boolean[] flags = new boolean[9];
			for(int c = 0; c < 9; c++) {
			   if(flags[state[r][c] - 1]) { return false; }
			   flags[state[r][c] - 1] = true;
			}
			return true;
		}
		
		public boolean isColSolved(int c) {
			if(!isColFull(c)) { return false; }
			boolean[] flags = new boolean[9];
			for(int r = 0; r < 9; r++) {
			   if(flags[state[r][c] - 1]) { return false; }
			   flags[state[r][c] - 1] = true;
			}
			return true;
		}
		
		public int numEmptyRows(int c) {
			int count = 0;
			for(int r = 0; r < 9; r++) {
			   if(state[r][c] == 0) { count++; }
			}
			return count;
		}
		
		public int numEmptyCols(int r) {
			int count = 0;
			for(int c = 0; c < 9; c++) {
			   if(state[r][c] == 0) { count++; }
			}
			return count;
		}
		
		public boolean isRowFull(int r) {
			for(int c = 0; c < 9; c++) {
				if(state[r][c] == 0) {
					return false;
				}
			}
			return true;
		}
		
		public boolean isColFull(int c) {
			for(int r = 0; r < 9; r++) {
				if(state[r][c] == 0) {
					return false;
				}
			}
			return true;
		}
		
		
		public boolean isFull() {
			for(int r = 0; r < 9; r++) {
				if(!isRowFull(r)) { return false; }
			}	
			return true;
		}
		
		public State clone() {
			State state = new State();
			state.guessed = guessed;
			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					state.state[r][c] = this.state[r][c];
				}
			}	
			return state;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for(int r = 0; r < 9; r++) {
				for(int c = 0; c < 9; c++) {
					sb.append(state[r][c]);
				}
				sb.append("\n");
			}	
			return sb.toString();
		}
		
	}
	
}
