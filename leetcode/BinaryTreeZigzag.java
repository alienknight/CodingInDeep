import java.util.*;
public class BinaryTreeZigzag {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		ArrayList<TreeNode> r = new ArrayList<TreeNode>();
		ArrayList<Integer> r1 = new ArrayList<Integer>();
		r.add(root);
		r1.add(root.val);
		result.add(r);
		res.add(r1);
		int size = 0;
		while (size != result.size()) {
			size = result.size();
			ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
			ArrayList<Integer> temp1 = new ArrayList<Integer>();

			for (int i = result.get(result.size() - 1).size() - 1; i >= 0; i--) {
				if (size % 2 != 0) {
					if (result.get(result.size() - 1).get(i).right != null) {
						temp.add(result.get(result.size() - 1).get(i).right);
						temp1.add(result.get(result.size() - 1).get(i).right.val);
					}
					if (result.get(result.size() - 1).get(i).left != null) {
						temp.add(result.get(result.size() - 1).get(i).left);
						temp1.add(result.get(result.size() - 1).get(i).left.val);
					}
				} else {
					if (result.get(result.size() - 1).get(i).left != null) {
						temp.add(result.get(result.size() - 1).get(i).left);
						temp1.add(result.get(result.size() - 1).get(i).left.val);
					}
					if (result.get(result.size() - 1).get(i).right != null) {
						temp.add(result.get(result.size() - 1).get(i).right);
						temp1.add(result.get(result.size() - 1).get(i).right.val);
					}
				}
			}

			if (temp.size() != 0) {
				result.add(temp);
				res.add(temp1);
			}
		}
		return res;
	}
}
