
public class RegularExpression {
	public static boolean isMatch(String s, String p) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    if(s==null)
	        return p==null;
	    return helper(s,p,0,0);
	}
	public static boolean helper(String s, String p, int i, int j) {
	    if(j==p.length())
	        return i==s.length();
	    if(j==p.length()-1 || p.charAt(j+1)!='*') {
//	        if(i==s.length())
//	            return false;
	        return (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') && helper(s,p,i+1,j+1);
	    }
	    while(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')) {
	        if(helper(s,p,i,j+2))
	            return true;
	        i++;
	    }
	    return helper(s,p,i,j+2);
	}
	public static void main(String[] args) {
		String s = "ab";
		String p = ".*c";
		isMatch(s,p);
	}
}

/*
 *     bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        assert(s && p);
        if(*p=='\0')
            return *s=='\0';
        if(*(p+1)!='*') {
        //    if(*p=='*')
         //       return false;
            assert(*p!='*');
            return ((*p==*s) || (*p=='.' && *s!='\0')) && isMatch(s+1, p+1);
        }
        while((*p==*s) || (*p=='.' && *s!='\0')) {
            if(isMatch(s,p+2))
                return true;
            s++;
        }
        return isMatch(s,p+2);
    }
    */
