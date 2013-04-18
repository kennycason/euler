package _067;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import lib.DynamicAlgorithms;
import lib.IntTriangle;


public class _067 {

	public static void main(String[] args) {
		new _067();
	}

	public _067() {
	
		IntTriangle triangle = new IntTriangle(100);
		
		int[] data = loadFromFile("_067/triangle.dat");
		triangle.setAll(data);
		
		System.out.println(triangle);
		System.out.println("Calculating Max Paths");
		IntTriangle pathSums = DynamicAlgorithms.calculateMaxPaths(triangle);
		System.out.println(pathSums);
		System.out.println("Max Path: " + DynamicAlgorithms.getMaxPath(pathSums));
		
	}
	
	private int[] loadFromFile(String file) {
		List<Integer> data = new LinkedList<Integer>();
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);

			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;

			while ((line = br.readLine()) != null) {
				if(!"".equals(line)) {
					String[] arr = line.split(" ");
					for(String a : arr) {
						if(a.startsWith("0")) {
							a = a.substring(1);
						}
						data.add(Integer.parseInt(a));
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		int[] dataArr = new int[data.size()];
		int i = 0;
		for(int d : data) {
			dataArr[i] = d;
			i++;
		}
		return dataArr;
	}

}
