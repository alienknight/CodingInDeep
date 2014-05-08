
public class MaximumDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
