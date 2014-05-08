import java.util.*;
public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(S==null || T==null || S.length()<T.length())
            return "";
        int m = S.length();
        int n = T.length();
        int min = Integer.MAX_VALUE;
        String res = "";
        for(int i=0;i<=m-n;i++)
            for(int j=i+n;j<=m;j++) {
                if(min(S.substring(i,j), T) && j-i<min) {
                    res = S.substring(i,j);
                    min = j-i;
                }
            }
        return res;
    }
    public boolean min(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<s.length();i++) {
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else 
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }
        for(int j=0;j<t.length();j++) {
            if(!map.containsKey(t.charAt(j)))
                return false;
            else {
                map.put(t.charAt(j),map.get(t.charAt(j))-1);
                if(map.get(t.charAt(j))==0)
                    map.remove(t.charAt(j));
            }
        }
        return true;
    }
    public static void main(String[] args) {
    	String s = "abc";
    	String t = "ac";
    	minWindow(s,t);
    }
}

/*
 *     public boolean isSubstring(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        String s1 = String.valueOf(ss);
        String t1 = String.valueOf(tt);
        if(s1.equals(t1))
            return true;
        if(s1.length()==t1.length())
            return false;
        int i=0, j=0;
        while(i<s1.length() && j<t1.length()) {
            if(s1.charAt(i)==t1.charAt(j)) {
                i++;
                j++;
            }
            else if(s1.charAt(i)-t1.charAt(j) > 0)
                return false;
            else
                i++;
        }
        if(j==t1.length())
            return true;
        else
            return false;
    }
    */

/*
public boolean isSubstring(String s, String t) {
ArrayList<Character> test = new ArrayList<Character>();
for(int i=0;i<t.length();i++) 
    test.add(t.charAt(i));
for(int j=0;j<s.length() && !test.isEmpty();j++)
    if(test.contains(s.charAt(j)))
        test.remove(test.indexOf(s.charAt(j)));				///////Why index not object
if(test.isEmpty())
    return true;
return false;
}*/