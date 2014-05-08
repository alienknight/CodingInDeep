import java.util.*;
public class GrayCode {
/*    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        int count = 1<<n;
        for(int i=0;i<count;i++) {
            res.add(i^i>>1);
        }
        return res;
    }*/

	public ArrayList<Integer> grayCode(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(0);
		if (n == 0)
			return res;
		for (int m = 0; m < n; m++) {
			int size = res.size();
			while (size-- > 0) {
				int temp = res.get(size);
				temp += 1 << m;
				res.add(temp);
			}
		}
		return res;
	}
}