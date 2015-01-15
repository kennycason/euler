package problems._102;

import main.Problem;
import main.annotations.Solved;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Solved
public class _102 extends Problem {

	public static void main(String[] args) {
		Problem p = new _102();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int numContained = 0;
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("problems/_102/triangles.txt");

			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;

			int ax,ay;
			int bx,by;
			int cx, cy;
			while ((line = br.readLine()) != null) {
				if (!"".equals(line)) {
					String[] arr = line.split(",");
					ax = Integer.parseInt(arr[0]);
					ay = Integer.parseInt(arr[1]);
					bx = Integer.parseInt(arr[2]);
					by = Integer.parseInt(arr[3]);
					cx = Integer.parseInt(arr[4]);
					cy = Integer.parseInt(arr[5]);
					
					double abc = area(ax, ay, bx, by, cx, cy);
					/*
					 *  o = origin
					 *  triangle abc area is equal to abo + bco + aco
					 */
					double ab0 = area(ax, ay, bx, by, 0, 0);
					double bc0 = area(0, 0, bx, by, cx, cy);
					double ac0 = area(ax, ay, 0, 0, cx, cy);
					if(abc == ab0 + bc0 + ac0) {
						numContained++;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		this.answer = numContained;
	}
	
	/*
	 *  found a faster way to calculate area of triangle
	 *  http://en.wikipedia.org/wiki/Triangle
	 */
	private double area(int ax, int ay, int bx, int by,int cx, int cy) {
		return Math.abs((ax - cx) * (by - ay) - (ax - bx) * (cy - ay));
	}

}
