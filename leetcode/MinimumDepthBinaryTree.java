
public class MinimumDepthBinaryTree {
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return 0;
        else if(root.left==null && root.right==null)
            return 1;
        else if(root.left==null || root.right==null)
            return 1+Math.max(minDepth(root.left), minDepth(root.right));
        else
            return 1+Math.min(minDepth(root.left), minDepth(root.right));
    }
}
