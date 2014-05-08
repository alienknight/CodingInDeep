import java.util.*;
public class UniqueBinarySearchTree2 {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateTrees(1,n);
    }
    public ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(start > end) {
            result.add(null);
            return result;
        }
        for(int i=start;i<=end;i++) {
            for(TreeNode left : generateTrees(start,i-1)) {
                for(TreeNode right : generateTrees(i+1,end)) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = left;
                    temp.right = right;
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
