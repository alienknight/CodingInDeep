import java.util.*;
public class RecoverTree {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
    public static void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null || (root.left==null && root.right==null))
            return ;
        LinkedList<TreeNode> l = new LinkedList<TreeNode>();
        helper(root,l);
        int x=0, y=0;
        for(int i=0;i<l.size()-1;i++) {
            if(i==0 && l.get(0).val>l.get(1).val)
                break;
            else if(i>0 && l.get(i).val>l.get(i-1).val && l.get(i).val>l.get(i+1).val) {
                x = i;
                break;
            }
        }
        for(int j=l.size()-1;j>0;j--) {
            if(j==l.size()-1 && l.get(j).val<l.get(j-1).val) {
                y = j;
                break;
            }
            else if(j< l.size()-1 && l.get(j).val<l.get(j-1).val && l.get(j).val<l.get(j+1).val) {
                y = j;
                break;
            }
        }
        int temp = l.get(x).val;
        l.get(x).val = l.get(y).val;
        l.get(y).val = temp;
    }
    public static void helper(TreeNode root, LinkedList<TreeNode> l) {
        if(root==null)
            return ;
        helper(root.left,l);
        l.add(root);
        helper(root.right,l);
    }
    public static void main(String[] args) {
    	TreeNode r1 = new TreeNode(1);
    	TreeNode r2 = new TreeNode(2);
    	TreeNode r3 = new TreeNode(3);
    	r1.left = r2;
    	r1.right = r3;
    	recoverTree(r1);
    }
}


/*
 * 

void proc(TreeNode *root, TreeNode *&n1, TreeNode *&n2, TreeNode *&prev)
{
    if(!root)
        return;
    proc(root->left,n1,n2,prev);
    if(prev && prev->val > root->val)
    {
        n2 = root;
        if(!n1)
            n1 = prev;
    }
    prev = root;
    proc(root->right,n1,n2,prev);
}
void recoverTree(TreeNode *root) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    TreeNode *n1 = NULL;
    TreeNode *n2 = NULL;
    TreeNode *prev = NULL;
    proc(root,n1,n2,prev);
    if(n1 && n2)
        swap(n1->val,n2->val);
}

*/
