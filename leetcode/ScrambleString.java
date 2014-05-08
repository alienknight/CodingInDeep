import java.util.Arrays;


public class ScrambleString {
/*	boolean isScramble(String s1, String s2) {
	    if(s1.equals(s2))
	        return true;
	    boolean[][][] scrambled = new boolean[s1.length()][s2.length()][s1.length() + 1];
	    for(int i = 0; i < s1.length(); i++)
	        for(int j = 0; j < s2.length(); j++){
	            scrambled[i][j][0] = true; 
	            scrambled[i][j][1] = s1.charAt(i) == s2.charAt(j);
	        }

	    for(int i = s1.length() - 1; i >= 0 ; i--)
	        for(int j = s2.length() - 1; j >= 0; j--)
	            for(int n = 2; n <= Math.min(s1.length() - i, s2.length() - j); n ++)
	                for(int m = 1; m < n; m++){
	                    scrambled[i][j][n] |= scrambled[i][j][m] && scrambled[i + m][j + m][n - m] ||
	                            scrambled[i][j + n - m][m] && scrambled[i + m][j][n - m];
	                    if(scrambled[i][j][n])  break;
	                }
	    return scrambled[0][0][s1.length()]; 
	}
	*/
	public static boolean isScramble(String s1, String s2) {

	    return judge(s1,0,s1.length()-1,s2,0,s2.length()-1);
	}
	private static boolean judge(String s1, int low1, int high1, String s2, int low2, int high2) {
	    if(high1-low1 != high2-low2) {
	        System.out.println("error");
	        return false;
	    }
	    if(low1 == high1) return s1.substring(low1, low1+1).equals(s2.substring(low2, low2+1));

	    boolean result = false;
	    //the end position that the first half can reach 
	    for(int i = low1;i < high1;i++){
	        int size = i-low1;
	        result = result ||(
	                (judge(s1,low1,i,s2,low2,low2+size) && judge(s1,i+1,high1,s2,low2+size+1,high2))
	                || (judge(s1,low1,i,s2,high2-size,high2) && judge(s1,i+1,high1,s2,low2,high2-size-1)));

	    }
	    return result;
	}
	public static void main(String[] args) {
		String s1 = "abb";
		String s2 = "bab";
		isScramble(s1,s2);
	}
}
