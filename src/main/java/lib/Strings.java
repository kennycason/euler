package lib;

public class Strings {

	private Strings() {
		
	}
	
	public static boolean isPalindrome(String s) {
		int n = s.length();
	    for( int i = 0; i < n / 2; i++ ) {
	        if (s.charAt(i) != s.charAt(n-i-1)) {
	        	return false;
	        }
	    }
	    return true;  
	}

    public static void print(int[][] value) {
        final StringBuilder stringBuilder = new StringBuilder();
        for(int j = 0; j < value.length; j++) {
            for(int i = 0; i < value[j].length; i++) {
                stringBuilder.append(value[j][i]);
                if(i < value[i].length - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
	
}
