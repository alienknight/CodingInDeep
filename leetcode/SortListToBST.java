public class SortListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		return helper(head, null);
	}

	public TreeNode helper(ListNode start, ListNode end) {
		if (start == null || start == end)			//IMPORTANT
			return null;
		if (start.next == null)					//IMPORTANT	
			return new TreeNode(start.val);
		ListNode slow = start;
		ListNode fast = start;
		while (fast != end && fast.next != end) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = helper(start, slow);
		root.right = helper(slow.next, end);
		return root;
	}
}
