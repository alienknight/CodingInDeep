
public class BinaryTreeLevelOrderTraversal2 {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null)
            return new ArrayList<ArrayList<Integer>>();
        Stack<ArrayList<TreeNode>> buf = new Stack<ArrayList<TreeNode>>();
        ArrayList<TreeNode> t = new ArrayList<TreeNode>();
        t.add(root);
        buf.push(t);
        int size = 0;
        while(size!=buf.size()) {
            size = buf.size();
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            for(TreeNode n : buf.peek()) {
                if(n.left!=null) 
                    temp.add(n.left);
                if(n.right!=null)
                    temp.add(n.right);
            }
            if(temp.size()!=0)
                buf.push(temp);
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        while(!buf.isEmpty()) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            for(TreeNode a : buf.peek()) {
                res.add(a.val);
            }
            result.add(res);
            buf.pop();
        }
        return result;
    }
}
