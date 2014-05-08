import java.util.*;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		// ArrayList<ArrayList<String>> result = new
		// ArrayList<ArrayList<String>>();
		return dfs(s);
	}

	public ArrayList<ArrayList<String>> dfs(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if (s.length() == 0) {
			result.add(new ArrayList<String>());
			return result;
		}
		for (int i = 1; i <= s.length(); i++) {
			if (isPanlindrome(s.substring(0, i))) {
				ArrayList<ArrayList<String>> temp = dfs(s.substring(i));
				for (ArrayList<String> t : temp) {
					t.add(0, s.substring(0, i));
					result.add(t);
				}
			}
		}
		return result;
	}

	public boolean isPanlindrome(String s) {
		if (s.length() <= 1)
			return true;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
}

/*
 * public ArrayList<ArrayList<String>> partition(String s) { // Start typing
 * your Java solution below // DO NOT write main() function if(s==null) return
 * new ArrayList<ArrayList<String>>(); int len = s.length(); boolean[][] temp =
 * new boolean[len][len]; for(int i=0;i<len;i++) for(int j=0;j<len;j++)
 * temp[i][j] = false; for(int i=0;i<len;i++) for(int j=i;j<len;j++) {
 * if(s.charAt(i)==s.charAt(j) && (j-i<2 || temp[i+1][j-1])) temp[i][j] = true;
 * } return helper(s,temp); } public ArrayList<ArrayList<String>> helper(String
 * s, boolean[][] temp) { ArrayList<ArrayList<String>> res = new
 * ArrayList<ArrayList<String>>(); if(s.length()==0) res.add(new
 * ArrayList<String>()); for(int i=0;i<s.length();i++) if(temp[0][i]) {
 * for(ArrayList<String> list : helper(s.substring(i+1),temp)) {
 * list.add(0,s.substring(0,i+1)); res.add(list); } } return res; }
 */
