import java.util.*;
public class DisdinctSubsequences {
/*    public static int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(S==null || T==null || S.length()<T.length())
            return 0;
        ArrayList<String> result = new ArrayList<String>();
        result = helper(S,T.length());
        int count=0;
        for(String t : result) {
            if(t.equals(T))
                count++;
        }
        return count;
    }
    public static ArrayList<String> helper(String s, int len) {               /////////Combinations
        if(s.length()<len)
            return null;
        ArrayList<String> res = new ArrayList<String>();
        if(len==1) {
            for(int i=0;i<s.length();i++) {
                res.add(String.valueOf(s.charAt(i)));
            }
            return res;
        }
        for(int i=0;i<=s.length()-len;i++) {
            for(String t : helper(s.substring(i+1,s.length()),len-1)) {
                String temp = s.charAt(i)+t;
                res.add(temp);
            }
        }
        return res;
    }*/
    public static int numDistinct(String S, String T) {						//////////////////////Important
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] f = new int[T.length()+1];
        f[T.length()] = 1;
        for(int i=S.length()-1;i>=0;i--)
            for(int j=0;j<T.length();j++) {
                if(S.charAt(i)==T.charAt(j))
                    f[j] += f[j+1];
            }
        return f[0];
    }
    public static void main(String[] args) {
    	String s = "ddd";
    	String t = "dd";
    	numDistinct(s,t);
    }
}

/*
 *     public static int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(S,0,T,0);
    }
    public static int helper(String s, int a, String t, int b) {
        if(s==null || t==null || s.substring(a).length() < t.substring(b).length())
            return 0;
        if(b==t.length())
            return 1;
        int num = 0;
        for(int i=a;i<=s.length()-t.substring(b).length();i++) {
            if(s.charAt(i)==t.charAt(b))
                num += helper(s,i+1,t,b+1);
        }
        return num;
    }
    */
