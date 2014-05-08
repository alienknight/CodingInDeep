
public class longestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        String result = common(strs[0],strs[1]);
        if(result.equals(""))
            return "";
        for(int i=2;i<strs.length;i++)
        {
            result = common(strs[i],result);
        }
        return result;
    }
    public static String common(String m, String n)
    {
        if(m.length()==0 || n.length()==0)
            return "";
        StringBuffer com = new StringBuffer();
        int j = 0;
        while(j<m.length() && j<n.length())
        {
            if(m.charAt(j)==n.charAt(j))
            {
                com.append(m.charAt(j));
                j++;
            }
            else
                break;
        }
        if(com.length()==0)
            return "";
        return com.toString();
    }
    
    public static void main(String[] args)
    {
    	String[] a = {"a","b"};
    	longestCommonPrefix(a);
    }
}


/*


class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        if(strs.size() == 0) return "";

        int num = strs.size();
        int len = strs[0].size();

        for(int j = 0; j<len; j++){
            for(int i = 1; i <num; i++){
                if(strs[i][j]!=strs[i-1][j]){
                    return strs[0].substr(0,j);
                }
            }
        }
        return strs[0];
    }
};

*/