import java.util.*;

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		return helper(num, 0);
	}

	public ArrayList<ArrayList<Integer>> helper(int[] num, int count) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (count == num.length) {
			res.add(new ArrayList<Integer>());
			return res;
		}
		for (ArrayList<Integer> list : helper(num, count + 1)) {
			for (int i = 0; i <= list.size(); i++) {
				ArrayList<Integer> temp = new ArrayList<Integer>(list);
				temp.add(i, num[count]);
				res.add(temp);
			}
		}
		return res;
	}

//	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
//		if (num == null)
//			return null;
//		Arrays.sort(num);
//		return perm(num, 0, new boolean[num.length]);
//	}
//
//	public ArrayList<ArrayList<Integer>> perm(int[] num, int l, boolean[] used) {
//		ArrayList<ArrayList<Integer>> rl = new ArrayList<ArrayList<Integer>>();
//		if (l == num.length)
//			rl.add(new ArrayList<Integer>());
//		else
//			for (int i = 0; i < num.length; i++) {
//				if (used[i] || i != 0 && num[i] == num[i - 1] && !used[i - 1])
//					continue;
//				used[i] = true;
//				for (ArrayList<Integer> x : perm(num, l + 1, used)) {
//					x.add(0, num[i]);
//					rl.add(x);
//				}
//				used[i] = false;
//			}
//		return rl;
//	}

}