import java.util.*;
public class WordBreak2 {
    public static ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> res = new ArrayList<String>();
        helper(s,dict,res,"");
        return res;
    }
    public static void helper(String s, Set<String> dict, ArrayList<String> res, String pre) {
        if(s.length()==0) {
            res.add(pre);
            return ;
        }
        for(int i=1;i<=s.length();i++) {
            if(dict.contains(s.substring(0,i))) {
                String temp = pre.equals("") ? s.substring(0,i) : pre + " " + s.substring(0,i);
                helper(s.substring(i),dict,res,temp);
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
