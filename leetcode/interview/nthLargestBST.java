public class nLargest {
	static class Node {
		int val;
		Node left;
		Node right;

		public Node(int v) {
			val = v;
			left = null;
			right = null;
		}
	}

	static int count = 0;
	static int res;

	public static int nLargest(Node root, int n) {
		count = n;
		helper(root);
		return res;
	}

	public static void helper(Node root) {
		if (root == null)
			return ;
		helper(root.right);
		if (--count == 0)
			res = root.val;
		helper(root.left);
	}
}
