import java.util.*;
public class WordLadder {
	/////////////DFS will cause time limit exceed, 
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(start.equals(end))
            return 1;
        ArrayList<String> s = new ArrayList<String> ();
        return helper(start,end,dict,s,1);        
    }
    public int helper(String start, String end, HashSet<String> dict, ArrayList<String> s, int count) {
        if(trans(start,end))
            return count+1;
        if(s.containsAll(dict))
           return 0;
        ArrayList<String> temp = new ArrayList<String>();
        for(String t : dict) {
            if(trans(start,t)) {
                if(!s.contains(t)) {
                    s.add(t);
                    temp.add(t);
                }
            }
        }
        if(s.size()==0) //|| s.containsAll(dict))
            return 0;
        int min=Integer.MAX_VALUE;
        for(String a : temp) {
            min = Math.min(min,helper(a,end,dict,s,count+1));
        }
        return min;
    }
    public boolean trans(String a, String b) {
        int count=0;
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i)!=b.charAt(i))
                count++;
        }
        if(count==1)
            return true;
        else
            return false;
    }
}

/*
 *	BFS also cause time limit exceed
 *     public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(start.equals(end))
            return 1;
        ArrayList<String> s = new ArrayList<String> ();
        ArrayList<String> r = new ArrayList<String> ();
        r.add(start);
        return helper(r,end,dict,s,1);        
    }
    public int helper(ArrayList<String> r, String end, HashSet<String> dict, ArrayList<String> s, int count) {
        for(String str : r) {
            if(trans(str,end))
                return count+1;
        }
        if(s.containsAll(dict))
           return 0;
        ArrayList<String> temp = new ArrayList<String>();
        for(String a : r) {
            for(String t : dict) {
                if(trans(a,t)) {
                    if(!s.contains(t)) {
                        s.add(t);
                        temp.add(t);
                    }
                }
            }
        }
        
        if(s.size()==0)
            return 0;
        return helper(temp,end,dict,s,count+1);
    }
    */
