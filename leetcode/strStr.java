
public class strStr {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(needle.length()==0) return haystack;
        if(haystack.length()==0) return null;
        int m = haystack.length();
        int n = needle.length();
        if(m<n) return null;
        return helper(haystack,needle,m,n);
    }
    public String helper(String a, String b, int m, int n)
    {
        for(int i=0;i<m-n+1;i++)
        {
            if(a.charAt(i)==b.charAt(0))
            {
                for(int j=0;j<n;j++)
                {
                    if(a.charAt(i+j)!=b.charAt(j))
                        break;
                    if(j==n-1)
                    {
                        char[] result = a.toCharArray();
                        return String.valueOf(result,i,m-i);
                    }
                }
            }
        }
        return null;
    }
}
