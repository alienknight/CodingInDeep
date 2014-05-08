import java.util.*;

public class CombinationSum {
    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates.length==0 || target<0)
            return res;
        Arrays.sort(candidates);
        helper(candidates,target,res,new ArrayList<Integer>(),0);
        return res;
    }
    public static void helper(int[] candidates, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int count) {
        if(target<=0) {
            if(target==0) {
            	if(!res.contains(temp))
            		res.add(temp);
                return ;
            }
            return ;
        }
        for(int i=count;i<candidates.length;i++) {
            if(candidates[i]<=target) {
                ArrayList<Integer> t = new ArrayList<Integer>(temp);
                t.add(candidates[i]);
                helper(candidates,target-candidates[i],res,t,i);
            }
            else break;
        }
    }
    public static void main(String[] args) {
    	int[] candidates = {1,1};
    	int target = 1;
    	combinationSum(candidates, target);
    }
/*	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (candidates.length == 0)
			return list;
		ArrayList<Integer> init = new ArrayList<Integer>();
		helper(candidates, target, list, init);
		return list;
	}

	public void helper(int[] candidates, int target,
			ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp) {
		if (target == 0) {
			Collections.sort(temp, new Comparator<Integer>() {			//Important
				public int compare(Integer m, Integer n) {
					return m.compareTo(n);
				}
			});
			if (!list.contains(temp))
				list.add(temp);
			return;
		}
		for (int c : candidates) {
			if (c <= target / 2 || c == target) {
				int t = target - c;
				ArrayList<Integer> temp1 = new ArrayList<Integer>();
				// temp1 = temp;
				temp1.addAll(temp);										//Important
				temp1.add(c);
				helper(candidates, t, list, temp1);
			}
		}
	}
	/*
	 * public boolean duplicate(ArrayList<ArrayList<Integer>> list,
	 * ArrayList<Integer> temp) { for(ArrayList<Integer> a : list) {
	 * Collections.sort(a,new Comparator<Integer>(){ public int compare(Integer
	 * m, Integer n) { return m.compareTo(n); } }); if(a.size()==temp.size()) {
	 * int i=0; for(;i<a.size();i++) { if(a.get(i)!=temp.get(i)) break; }
	 * if(i==a.size()) return true; } } return false; }
	 */
}

/*
 *     public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(candidates.length==0)
            return result;
        Arrays.sort(candidates);
        ArrayList<Integer> cur = new ArrayList<Integer>();
        helper(candidates,target,i,0,cur,result);
        return result;
    }
    public void helper(int[] candidates, int target, int index, int sum, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> result) {
        if(sum>target)
            return ;
        if(sum==target) {
            if(!result.contains(cur)) 
                result.add(cur);
            return ;
        }
        for(int i=index;i<candidates.length;i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            temp.add(candidates[i]);
            helper(candidates,target,i,sum+candidates[i],temp,result);
        }
    }
    */
