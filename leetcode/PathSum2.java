import java.util.*;
public class PathSum2 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> fst = new ArrayList<Integer>();
        helper(root,sum,result,fst);
        return result;
    }
    public void helper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> fst) {
        if(root==null) return ;
        fst.add(root.val);
        if(root.left==null && root.right==null && root.val==sum) {
            ArrayList<Integer> temp = new ArrayList<Integer> (fst);
            result.add(temp);
            fst.remove(fst.size()-1);
            return ;
        }
        if(root.left!=null) helper(root.left,sum-root.val,result,fst);
        if(root.right!=null) helper(root.right,sum-root.val,result,fst);
        fst.remove(fst.size()-1);
    }
}

/*
 
    visit each node constant times
    the amortized time of add/remove an item on an ArrayList is O(1)
    making a copy for each result costs at most O(logn).

 *
public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
// Start typing your Java solution below
// DO NOT write main() function
ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
ArrayList<Integer> fst = new ArrayList<Integer>();
if(root==null)																							
    return result;
helper(root,sum,result,fst);
return result;
}
public void helper(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> fst) {
if(root==null) 
    return ;
fst.add(root.val);
if(root.left==null && root.right==null) {
    if(sum==root.val) {
        ArrayList<Integer> res = new ArrayList<Integer>(fst);
        result.add(res);
    }
}
else {
    helper(root.left,sum-root.val,result,fst);
    helper(root.right,sum-root.val,result,fst);
}
fst.remove(fst.size()-1);
}*/