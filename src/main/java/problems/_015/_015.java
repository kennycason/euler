package problems._015;

import lib.Probability;
import main.Problem;
import main.annotations.Solved;

@Solved
public class _015 extends Problem {

	public static void main(String[] args) {
		Problem p = new _015();
		p.run();
		System.out.println(p.answer());
	}

	/*
	 * observations
	 * 1 x 1, 0 branches,  1 top path * 2		= 2
	 * 2 x 2, 3 branches,  3 top paths * 2		= 6
	 * 3 x 3, 12 branches,  10 top paths * 2	= 20
	 * 
	 * use dynamic programming to show all paths and sum path intersections 
	 * path-tree
	 *	        1   		// start
	 *	       1 1			// 2 branches from start
	 * 	      1 2 1 		// first corner, 2 outer branches, 2 inner branches over lap, finishes 1x1 grid
	 * 	     1 3 3 1		// 2nd corner, 2 outer branches continue, 2 more paths for previous 2 inner branches
	 * 	   1  4 6 4  1		// all paths reach end of 2x2 grid (LtoR,TtoB), now test to 3x3, hope it equals 20
	 *    1 5 10 10 5 1
	 *   1 6 15 20 15 6 1 	// yay, looks like pascals triangle
	 *   
	 *   We can use the simple combinations formula as we are just calculating the combinations of paths,
	 *   (n r) = n! / r!(n - r)!
	 *   
	 *   (2 1), 2 choose 1 = 2,
	 *   (4 2), 4 choose 2 = 12/2 = 6
	 *   (6 3), 6 choose 3 = 720/(6 * 6) = 720/36 = 20
	 *   
	 *   correlate combination results to observations above
	 *   
	 *   (grid_size * 2 grid_size), grid_size * 2 choose grid_size
	 *   
	 *   20x20 grid
	 *   (20*2 20), 40 choose 20 = 40! / 20!(40-20)! = ? 
	 *   it's a big number lets calculate it :P
	 */
	public void run() {
		int dim = 20;
		this.answer = Probability.bigCombination(dim * 2, dim);
	}
	
}
