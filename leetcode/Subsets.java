import java.util.ArrayList;
import java.util.*;


public class Subsets {
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> empty = new ArrayList<Integer>();
        result.add(empty);
        if(S.length==0)
            return result;
        Arrays.sort(S);
        for(int i=0;i<S.length;i++) {
            int j = result.size();
            while(j-->0) {
            	ArrayList<Integer> temp = new ArrayList<Integer>();
            	temp.addAll(result.get(j));
                result.add(result.size(),temp);
                result.get(result.size()-1).add(S[i]);
            }
        }
        return result;
    }
/*    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if(S.length==0)
            return result;
        result = helper(S,S.length);
        ArrayList<Integer> empty = new ArrayList<Integer>();
        result.add(empty);        
        return result;
    }
    public static ArrayList<ArrayList<Integer>> helper(int[] S, int count) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if(count==1)
        {
            for(int a : S)
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(a);
                result.add(temp);
            }
            return result;
        }
        result.addAll(helper(S,count-1));
        for(int b : S)
        {
            for(ArrayList<Integer> c : helper(S,count-1))
            {
                if(!c.contains(b))
                {
                    ArrayList<Integer> n = new ArrayList<Integer>();
                    n.addAll(c);
                    n.add(b);
                    Collections.sort(n,new Comparator<Integer>() {
                    	public int compare(Integer a, Integer b) {
                    		return a.compareTo(b);
                    	}
                    });
                    if(!result.contains(n))
                        result.add(n);
                }
            }
        }
        return result;
    }*/
    public static void main(String[] args) {
    	int[] S = {1,2};
    	subsets(S);
    }
}

/*
 public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
        if(S.length==0)
            return result;
        Arrays.sort(S);
        int count=0;
        while(count<S.length)
        {
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>> ();
            res.addAll(result);
            if(count==0)
            {
                for(int a : S)
                {
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(a);
                    result.add(temp);
                }
            }
            else
            {
                for(int b : S)
                for(ArrayList<Integer> c : res)
                {
                    if(!c.contains(b))
                {
                    ArrayList<Integer> n = new ArrayList<Integer>();
                    n.addAll(c);
                    n.add(b);
                    Collections.sort(n,new Comparator<Integer>() {
                        public int compare(Integer a, Integer b) {
                    		return a.compareTo(b);
                    	}
                    });
                    if(!result.contains(n))
                        result.add(n);
                }
                }
            }
            count++;
        }
        ArrayList<Integer> empty = new ArrayList<Integer>();
        result.add(empty);        
        return result;
    }*/
