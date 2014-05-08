public class NextRightPointer2 {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

    public static void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        while(root!=null) {
            TreeLinkNode next = null;
            TreeLinkNode pre = null;
            for(;root!=null;root=root.next) {
                if(next==null)
                    next = root.left!=null ? root.left : root.right;
                if(root.left!=null) {
                    if(pre!=null)
                        pre.next = root.left;
                    pre = root.left;
                }
                if(root.right!=null) {
                    if(pre!=null)
                        pre.next = root.right;
                    pre = root.right;
                }
            }
            root = next;
        }
    }
	
	public static void main(String[] args) {
		TreeLinkNode a = new TreeLinkNode(1);
		TreeLinkNode b = new TreeLinkNode(2);
		a.left = b;
		connect(a);
	}
}
