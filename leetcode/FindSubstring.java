import java.util.*;
public class FindSubstring {
	public ArrayList<Integer> findSubstring(String S, String[] L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L.length == 0)
			return result;
		ArrayList<String> t = new ArrayList<String>();
		t.add(L[0]);
		ArrayList<String> s = helper(L, t, 1);
		int len = s.get(0).length();
		for (int i = 0; i <= S.length() - len; i++) {
			if (s.contains(S.substring(i, i + len)))
				result.add(i);
		}
		return result;
	}

	public ArrayList<String> helper(String[] L, ArrayList<String> r, int count) {
		if (count == L.length)
			return r;
		ArrayList<String> s = new ArrayList<String>();
		String temp = null;

		for (int i = 0; i < r.size(); i++) {
			for (int j = 0 - L[0].length(); j <= r.get(i).length(); j = j
					+ L[0].length()) {
				if (j < 0)
					temp = L[count] + r.get(i);
				else if (j == r.get(i).length())
					temp = r.get(i) + L[count];
				else
					temp = r.get(i).substring(0, j) + L[count]
							+ r.get(i).substring(j);
				if (!s.contains(temp))
					s.add(temp);
			}
		}
		return helper(L, s, count + 1);
	}
}
