import java.util.*;
public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer> ();
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        while(!stack.isEmpty() || root!=null) {
            if(root!=null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.peek();
                res.add(stack.pop().val);
                root = root.right;
            }
        }
        return res;
    }
//    public ArrayList<Integer> inorderTraversal(TreeNode root) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        ArrayList<Integer> result = new ArrayList<Integer> ();
//        helper(root,result);
//        return result;
//    }
//    public void helper(TreeNode root, ArrayList<Integer> result) {
//        if(root==null)
//            return ;
//        helper(root.left,result);
//        result.add(root.val);
//        helper(root.right,result);
//    }
}


