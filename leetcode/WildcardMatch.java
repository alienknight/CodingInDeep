   public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p==null)
            return s==null;
        return Match(s,p,0,0);
    }
    public boolean Match(String s, String p, int i, int j) {
        if(j==p.length())
            return i==s.length();
        if(i==s.length()) {
            if(p.charAt(j)=='*')
                return Match(s,p,i,j+1);
            return false;
        }
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
            return Match(s,p,i+1,j+1);
        if(p.charAt(j)=='*') {
            while(i<=s.length()) {
                if(Match(s,p,i,j+1)) return true;
                i++;
            }
        }
        return false;
    }


/*
    public boolean Match(String s, String p, int i, int j) {
        if(j<p.length() && p.charAt(j)=='*') {
            while(j<p.length() && p.charAt(j)=='*')
                j++;
            if(j==p.length())
                return true;
            while(i<s.length() && !Match(s,p,i,j))
                i++;
            return i!=s.length();
        }
        if(i==s.length() || j==p.length()) 
            return i==s.length() && j==p.length();
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
            return Match(s,p,i+1,j+1);
        return false;
    }
*/


/*				C++ Version
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (*p == '*'){//return true;
            while(*p == '*') ++p;
            if (*p == '\0') return true;
            while(*s != '\0' && !isMatch(s,p)){
                ++s;                
            }
            return *s != '\0';
        }
        else if (*p == '\0' || *s == '\0') return *p == *s;
        else if (*p == *s || *p == '?') return isMatch(++s,++p);
        else return false;
    }
*/

