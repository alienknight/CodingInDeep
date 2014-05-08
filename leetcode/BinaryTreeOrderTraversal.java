import java.util.*;
public class BinaryTreeOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return res;
        ArrayList<TreeNode> r = new ArrayList<TreeNode>();
        ArrayList<Integer> r1 = new ArrayList<Integer>();
        r.add(root);
        r1.add(root.val);
        result.add(r);
        res.add(r1);
        int size = 0;
        while(size!=result.size()) {
            size = result.size();
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            ArrayList<Integer> temp1 = new ArrayList<Integer>();
            for(TreeNode n : result.get(result.size()-1)) {
                if(n.left!=null) {
                    temp.add(n.left);
                    temp1.add(n.left.val);
                }
                if(n.right!=null) {
                    temp.add(n.right);
                    temp1.add(n.right.val);
                }
            }
            if(temp.size()!=0) {
                result.add(temp);
                res.add(temp1);
            }
        }
        return res;
    }
}
