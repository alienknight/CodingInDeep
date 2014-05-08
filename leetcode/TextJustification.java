import java.util.*;
//need simplify
public class TextJustification {
	public static ArrayList<String> fullJustify(String[] words, int L) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		if (words.length == 0)
			return result;
		int len = words.length;
		int m = 0;
		while (m < len) {
			int n = m;
			int count = 0;
			StringBuffer sb = new StringBuffer();
			sb.append(words[n]);
			int etr = words[n].length();
			while (n + 1 < len && etr + words[n + 1].length() + 1 <= L) {
				etr = etr + words[n + 1].length() + 1;
				n++;
				count++;
			}
			if (m == n) {
				for (int i = 0; i < L - words[m].length(); i++)
					sb.append(" ");
				result.add(sb.toString());
				m++;
			} else {
				int l = L - etr;// extra space
				int x, y;
				if (count == 0) {
					x = 0;
					y = 0;
				} else {
					x = l / count;
					y = l % count;
				}
				m++;
				if (n != len - 1) {
					while (m <= n) {
						for (int i = 0; i <= x; i++)
							sb.append(" ");
						if (y > 0)
							sb.append(" ");
						sb.append(words[m]);
						m++;
						y--;
					}
				} else {
					while (m <= n) {
						sb.append(" ");
						sb.append(words[m]);
						if (m == n)
							for (int j = 0; j < l; j++)
								sb.append(" ");
						m++;
					}
				}
				result.add(sb.toString());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String[] s = { "a", "b", "c" };
		int L = 1;
		fullJustify(s, L);
	}
}

/*
 * public ArrayList<String> fullJustify(String[] words, int L) {
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> res = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    int cur = 0;
    int len = 0;

    while (cur < words.length) {
        sb.setLength(0);
        sb.append(words[cur]);

        list.clear();
        len = words[cur].length();
        cur++;

        while (cur<words.length && len + 1 + words[cur].length() <= L) {
            list.add(" " + words[cur]);
            len += words[cur].length() + 1;
            cur++;
        }

        if (cur < words.length && list.size() > 0) {
            int spaces = L - len;
            int avg = spaces / list.size();
            int rem = spaces % list.size();
            for (int i=0; i<list.size(); i++) {
                appendSpaces(sb, i<rem? avg+1 : avg);
                sb.append(list.get(i));
            }
        }
        else {
            for (int i=0; i<list.size(); i++) sb.append(list.get(i));
            appendSpaces(sb, L - len);
        }

        res.add(sb.toString());
    }
    return res;
}

private void appendSpaces(StringBuilder sb, int n) {
    for (int i=0; i<n; i++) sb.append(' ');
}*/
