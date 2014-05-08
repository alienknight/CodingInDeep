
public class BinaryTreeMaxSum {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
//    public static int maxPathSum(TreeNode root) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        int psum = Integer.MIN_VALUE;
//        int[] maxsum = {Integer.MIN_VALUE};
//        helper(root,psum,maxsum);
//        return maxsum[0];
//    }
//    public static int helper(TreeNode root, int psum, int[] maxsum) {
//        if(root==null)
//            return 0;
//        int left = helper(root.left,psum,maxsum);
//        int right = helper(root.right,psum,maxsum);
//        psum = Math.max(root.val,Math.max(root.val+left, root.val+right));	//////cannot be 'root.val+left+right' since path can only be one branch
//        maxsum[0] = Math.max(maxsum[0],Math.max(psum,root.val+left+right));
//        return psum;
//    }
    static int max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        int psum = 0;
        helper(root,psum);
        int n = max;
        return max;
    }
    public static int helper(TreeNode root, int psum) {
        if(root==null)
            return 0;
        int left = helper(root.left, psum);
        int right = helper(root.right, psum);
        psum = Math.max(root.val, Math.max(root.val+left, root.val+right));
        max = Math.max(max, Math.max(psum, root.val+left+right));
        return psum;
    }
    public static void main(String[] args) {
    	TreeNode n = new TreeNode(-3);
    	maxPathSum(n);
    	System.out.print(max);
    }
}
