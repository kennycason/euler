package problems._067;

import lib.DynamicAlgorithms;
import lib.IntTriangle;
import main.Problem;
import main.annotations.Solved;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

@Solved
public class _067 extends Problem {

	public static void main(String[] args) {
		Problem p = new _067();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
	
		IntTriangle triangle = new IntTriangle(100);
		
		int[] data = loadFromFile("problems/_067/triangle.dat");
		triangle.setAll(data);
		
		//System.out.println(triangle);
		IntTriangle pathSums = DynamicAlgorithms.calculateMaxPaths(triangle);
		//System.out.println(pathSums);
		this.answer = DynamicAlgorithms.getMaxPath(pathSums);
		
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
