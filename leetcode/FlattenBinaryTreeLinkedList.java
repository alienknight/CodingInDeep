public class FlattenBinaryTreeLinkedList {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (root == null || (root.left == null && root.right == null))
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if (left != null) {
			root.right = left;
			root.left = null;
			TreeNode rightmost = left;
			while (rightmost.right != null)
				rightmost = rightmost.right;
			rightmost.right = right;
		}
		flatten(root.right);
	}
}
