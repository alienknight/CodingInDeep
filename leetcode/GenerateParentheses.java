import java.util.*;
public class GenerateParentheses {
    public static ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        if(n>0)
            generate(result,"",0,0,n);
        return result;
    }
    public static void generate(ArrayList<String> result, String s, int l, int r, int n) {
        if(l==n)
        {
            for(int i=0;i<n-r;i++)
            {
                s = s.concat(")");
            }
            result.add(s);
            return ;
        }
        generate(result,s.concat("("),l+1,r,n);
        if(l>r)
            generate(result,s.concat(")"),l,r+1,n);
    }
    public static void main(String[] args) {
    	int n = 1;
    	generateParenthesis(n);
    }
}
