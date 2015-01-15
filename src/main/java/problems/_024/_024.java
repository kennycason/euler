package problems._024;

import lib.Lexographic;
import main.Problem;
import main.annotations.Solved;

import java.util.List;

@Solved
public class _024 extends Problem {

	public static void main(String[] args) {
		Problem p = new _024();
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
