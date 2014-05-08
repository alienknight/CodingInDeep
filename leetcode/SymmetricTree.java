
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null || root.left==null && root.right==null) return true;
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null || right==null) return left==null && right==null;
        if(left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
//    public boolean isSymmetric(TreeNode root) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(root==null)
//            return true;
//        ArrayList<TreeNode> l = new ArrayList<TreeNode>();
//        helper(root,l);
//        for(int i=0;i<=l.size()/2;i++) {
//            if(l.get(i).val!=l.get(l.size()-1-i).val)
//                return false;
//        }
//        return true;
//    }
//    public void helper(TreeNode root, ArrayList<TreeNode> l) {
//        if(root==null)
//            return ;
//        helper(root.left,l);
//        l.add(root);
//        helper(root.right,l);
//    }
}
