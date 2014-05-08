public class ConstructBinaryTreePosIn {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (postorder.length == 0)
			return null;
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		if (postorder.length == 1)
			return root;
		int i = inorder.length - 1;
		for (; inorder[i] != root.val; i--)
			;
		if (i < inorder.length - 1) {
			root.right = buildTree(
					Arrays.copyOfRange(inorder, i + 1, inorder.length),
					Arrays.copyOfRange(postorder, i, postorder.length - 1));
		}
		if (i > 0) {
			root.left = buildTree(Arrays.copyOfRange(inorder, 0, i),
					Arrays.copyOfRange(postorder, 0, i));
		}
		return root;
	}
}
