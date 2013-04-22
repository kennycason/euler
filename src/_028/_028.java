package _028;



public class _028 {

	public static void main(String[] args) {
		new _028();
	}

	public _028() {
		int dim = 1001;
		int[][] mat = drawSpiralMatrix(dim);
		int sum = sumDiagonals(mat);
		System.out.println(sum);
	}
	
	private int sumDiagonals(int[][] mat) {
		int sum = 0;
		int dim = mat[0].length;
		for(int x = 0; x < dim; x++) {
			sum += mat[x][0 + x] + mat[x][dim - 1 - x];
		}
		return sum - mat[dim / 2][dim / 2]; // subtract center as it was counted twice
	}
	
	private int[][] drawSpiralMatrix(int dim) {
		int[][] mat = new int[dim][dim];
		if(dim % 2 == 0) {
			return mat;
		}
		int x = dim / 2;
		int y = dim / 2;
		int dx = 0;
		int dy = 0;
		int i = 0;
		for(;;) {
			x += dx;
			y += dy;
			i++;
			mat[x][y] = i;
			if(x == dim - 1 && y == 0) {
				return mat;
			}
			if(dx == 0 && dy == 0) { // center
				dx = 1; dy = 0;
			} else if(dx == 1 && dy == 0) { // moving right
				if(mat[x][y + 1] == 0) { // stop when space below you is empty, 
					dx = 0; dy = 1; // move down
				}
			} else if(dx == 0 && dy == 1) { // moving down
				if(mat[x - 1][y] == 0) { // stop when space to left you is empty, 
					dx = -1; dy = 0; // move left
				}	
			} else if(dx == -1 && dy == 0) { // moving left
				if(mat[x][y - 1] == 0) { // stop when space to above you is empty, 
					dx = 0; dy = -1; // move up
				}	
			} else if(dx == 0 && dy == -1) { // moving up
				if(mat[x + 1][y] == 0) { // stop when space to right you is empty, 
					dx = 1; dy = 0; // move left
				}	
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void print(int[][] mat) {
		for(int y = 0; y < mat[0].length; y++) {
			for(int x = 0; x < mat.length; x++) {
				System.out.print(mat[x][y] + "\t");
			}		
			System.out.println();
		}
	}

}
