import java.util.*;
public class RestoreIPAddresses {
//    public static ArrayList<String> restoreIpAddresses(String s) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        ArrayList<String> result = new ArrayList<String>();
//        if(s==null || s.length()<4)
//            return result;
//        helper(s,result,"",0);
//        return result;
//    }
//    
//    public static void helper(String s, ArrayList<String> result, String cur, int count) {
//        int len = cur.length()-count;
//        if(len==s.length()) {
//            if(count==4) {
//                cur = cur.substring(0,cur.length()-1);
//                result.add(cur);
//                return ;
//            }
//            else
//                return ;
//        }
//        if(count>4)
//            return ;
//        for(int i=1;i<=3;i++) {
//            if(len+i>s.length())
//                return ;
//            String sub = s.substring(len,len+i);
//            int temp = Integer.parseInt(sub);
//            if(temp==0 && sub.length()==1 || temp>0 && temp<256 && sub.charAt(0)!='0') {
//                String sub1 = cur+sub + ".";
//                helper(s,result,sub1,count+1);
//            }
//        }
//    }
    public static ArrayList<String> restoreIpAddresses(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<String> res = new ArrayList<String>();
        String buf = "";
        helper(s,res,buf,0);
        return res;
    }
    public static void helper(String s, ArrayList<String> res, String buf, int count) {
        int len = buf.length() - count;
        if(len==s.length()) {
            if(count==4) {
                res.add(buf.substring(0,buf.length()-1));
                return ;
            }
            return ;
        }
        if(count > 4) return ;
        for(int i=len+1; i<=len+3 && i<=s.length(); i++) {
            int t = Integer.parseInt(s.substring(len,i));
            if(t<256 && t>=0) {
                if(s.charAt(len)=='0' && i>len+1) return;
                String temp = buf + s.substring(len,i) + ".";
                helper(s,res,temp,count+1);
            }
        }
    }
    
    public static void main(String[] args) {
    	String s = "010010";
    	restoreIpAddresses(s);
    }
}
