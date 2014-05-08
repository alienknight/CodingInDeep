
public class SumRootToLeafNumber {
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return 0;
        return helper(0, root);
    }
    public int helper(int sum, TreeNode t) {
        if(t.left==null && t.right==null)
            return sum*10+t.val;
        else if(t.left==null)
            return helper(sum*10+t.val,t.right);
        else if(t.right==null)
            return helper(sum*10+t.val,t.left);
        else
            return helper(sum*10+t.val,t.left) + helper(sum*10+t.val,t.right);
    } 
}
