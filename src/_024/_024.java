package _024;

import java.util.List;

import lib.Lexographic;



public class _024 {
	
	public static void main(String[] args) {
		new _024();
	}

	public _024() {
		// sanity tests
		// System.out.println(Lexographic.enumerate(new char[] {'0', '1', '2'}));
		// System.out.println(Lexographic.enumerate(new char[] {'0', '1', '2', '3'}));
		List<String> enums = Lexographic.enumerate(new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'});
		System.out.println(enums.get(1000000 - 1));
	}	

}
