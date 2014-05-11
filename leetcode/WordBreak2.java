import java.util.*;
public class WordBreak2 {
    // public static ArrayList<String> wordBreak(String s, Set<String> dict) {
    //     // Note: The Solution object is instantiated only once and is reused by each test case.
    //     ArrayList<String> res = new ArrayList<String>();
    //     helper(s,dict,res,"");
    //     return res;
    // }
    // public static void helper(String s, Set<String> dict, ArrayList<String> res, String pre) {
    //     if(s.length()==0) {
    //         res.add(pre);
    //         return ;
    //     }
    //     for(int i=1;i<=s.length();i++) {
    //         if(dict.contains(s.substring(0,i))) {
    //             String temp = pre.equals("") ? s.substring(0,i) : pre + " " + s.substring(0,i);
    //             helper(s.substring(i),dict,res,temp);
    //         }
    //     }
    // }
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        if(s==null)
            return null;
        boolean[] check = new boolean[s.length()+1];
        check[s.length()] = true;
        for(int i=s.length()-1;i>=0;i--)
            for(int j=s.length();j>=i;j--) {
                if(dict.contains(s.substring(i,j)) && check[j])
                    check[i] = true;
            }
        ArrayList<String> res = new ArrayList<String>();
        helper(s,dict,"",res,check,0);
        return res;
    }
    public static void helper(String s, Set<String> dict, String temp, ArrayList<String> res, boolean[] check, int index) {
        if(s.length()==0) {
            res.add(temp);
            return ;
        }
        for(int i=1;i<=s.length();i++) {
            if(dict.contains(s.substring(0,i)) && check[i+index]) {
                String t = temp.equals("") ? s.substring(0,i) : temp+" "+s.substring(0,i);
                helper(s.substring(i), dict, t, res, check, index+i);
            }
        }
    }
    public static void main(String[] args) {
    	String s = "catsanddog";
    	Set<String> set = new HashSet<String>();
    	set.add("cats");
    	set.add("and");
    	set.add("dog");
    	set.add("cat");
    	set.add("sand");
    	wordBreak(s,set);
    }
}
