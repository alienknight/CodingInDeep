
public class CountAndSay {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0) return "";
        if(n==1) return "1";
        int count = 1;
        String a = "1";
        return helper(n,count,a);
    }
    public String helper(int n, int count,String s) {
        if(count==n) return s;
        int label = 1;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++)
        {
            if(i!=s.length()-1 && s.charAt(i)==s.charAt(i+1))
            {
                label++;
            }
            else
            {
                sb.append(String.valueOf(label));
                sb.append(String.valueOf(s.charAt(i)));
                label = 1;
            }
        }
        return helper(n,++count,sb.toString());
    }
}
