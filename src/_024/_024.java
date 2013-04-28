package _024;

import java.util.List;

import lib.Lexographic;
import main.AbstractProblem;



public class _024 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _024();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		// sanity tests
		// System.out.println(Lexographic.enumerate(new char[] {'0', '1', '2'}));
		// System.out.println(Lexographic.enumerate(new char[] {'0', '1', '2', '3'}));
		List<String> enums = Lexographic.enumerate(new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'});
		this.answer = enums.get(1000000 - 1);
	}	

}
