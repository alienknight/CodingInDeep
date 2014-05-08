import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class CombinationSumUnique {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length==0) return result;
        ArrayList<Integer> temp = new ArrayList<Integer> ();
        Arrays.sort(num);
        helper(num,target,result,temp,0);
        return result;
    }
    public void helper(int[] num, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int count) {
        if(target==0)
        {
            Collections.sort(temp,new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return a.compareTo(b);
                }
            });
            if(!result.contains(temp))
                result.add(temp);
            return ;
        }
        for(int i=count;i<num.length;i++)
        {
            if(num[i]<=target/2 || num[i]==target)
            {
                int t = target - num[i];
                ArrayList<Integer> temp1 = new ArrayList<Integer>();
                temp1.addAll(temp);
                temp1.add(num[i]);
                helper(num,t,result,temp1,++count);
            }
        }
    }
}

/*
 *     public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length==0)
            return result;
        Arrays.sort(num);
        ArrayList<Integer> cur = new ArrayList<Integer>();
     //   for(int i=0;i<num.length;i++)
        helper(num,target,-1,0,cur,result);
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
        for(int i=index+1;i<candidates.length;i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            temp.add(candidates[i]);
            helper(candidates,target,i,sum+candidates[i],temp,result);
        }
    }
    */
