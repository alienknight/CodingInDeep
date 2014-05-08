
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s.trim();
        if(s.length()==0)
            return true; 
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++) {
            if((s.charAt(i)-'A'>=0 && s.charAt(i)-'A'<26) || (s.charAt(i)-'a'>=0 && s.charAt(i)-'a'<26) || (s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<10))
                sb.append(s.charAt(i));
        }
        String t = sb.toString();
        if(t.length()==0)
            return true;  
        for(int j=0;j<t.length()/2;j++) {
            if(Character.toUpperCase(t.charAt(j))!=Character.toUpperCase(t.charAt(t.length()-1-j)))
                return false;
        }
        return true;
    }
}
