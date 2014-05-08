
public class RecoverBinaryTree {
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        TreeNode[] rec = {null,null};
        find(root,null,rec);
        int temp = rec[0].val;
        rec[0].val = rec[1].val;
        rec[1].val = temp;
    }
    public TreeNode find(TreeNode root, TreeNode pre, TreeNode[] rec) {
        if(root==null)
            return pre;
        pre = find(root.left,pre,rec);
        if(pre!=null && root.val<pre.val) {
            if(rec[0] == null && rec[1] == null) {
                rec[0] = pre;
                rec[1] = root;
            }
            else
                rec[1] = root;
        }
        return find(root.right,root,rec);
    }
}
