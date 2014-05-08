public class NextRightPointer {
	/*
	 * The problem states that you can only use constant space. To get to the
	 * leaf nodes, a recursive solution needs to be log2(n) calls deep, and each
	 * call has a call stack, which takes up memory. This means that a recursive
	 * solution isn't constant memory, but O(log(n)) memory. To solve this, you
	 * just replace the recursive call with a while loop wrapping all of your
	 * logic.
	 */
	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
        while(root!=null && root.left!=null && root.right!=null) {
            TreeLinkNode next = root.left;
            for(;root!=null;root = root.next) {
                root.left.next = root.right;
                if(root.next!=null)
                    root.right.next = root.next.left;
            }
            root = next;
        }
	}
}

/*
void connect(TreeLinkNode *root) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    if (!root || (!root->left && !root->right))
        return;
    root->left->next = root->right;
    if (root->next) 
        root->right->next = root->next->left;

    connect(root->left);
    connect(root->right);
}
 */
