package _059;

import java.util.Arrays;

import lib.FileReader;
import main.AbstractProblem;

public class _059 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _059();
		p.run();
		System.out.println(p.answer());
	}
	
	public _059() {
		solved(false);
	}

	public void run() {
		int[] codes = readCode();
		System.out.println(Arrays.toString(codes));
	}

	private int[] readCode() {
		FileReader reader = new FileReader("_059/cipher1.txt");
		String data = reader.getContent();
		String[] arr = data.replace("\n", "").split(",");
		int[] codes = new int[arr.length];
		for(int i = 0; i < codes.length; i++) {
			codes[i] = Integer.parseInt(arr[i]);
		}
		return codes;
	}

}
