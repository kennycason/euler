package _022;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import lib.FileReader;


public class _022 {

	public static void main(String[] args) {
		new _022();
	}

	public _022() {
		List<String> names = loadFromFile("_022/names.txt");
		Collections.sort(names);
		long sum = 0;
		int i = 1;
		for(String name : names) {
			sum += (i * score(name));
			// System.out.println(i + ": " + name + " " + score(name) + " = " + i * score(name));
			i++;
		}
		System.out.println(sum);
	}
	
	private int score(String name) {
		int score = 0;
		for(char c : name.toCharArray()) {
			score += c - 65 + 1;
		}
		return score;
	}
	
	private List<String> loadFromFile(String file) {
		FileReader reader = new FileReader(file);
		String content = reader.getContent();
		
		List<String> names = new LinkedList<String>();
		content = content.replaceAll("\"|\n", "");
		for(String name : content.split(",")) {
			names.add(name);
		}
		return names;
	}

}
