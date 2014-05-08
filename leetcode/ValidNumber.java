
public class ValidNumber {
	public boolean isNumber(String s) {
		  return s.matches("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$");
		}
		
/*    public static boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = s.trim();
        if(s.length()==0)
            return false;
        for(int i=0;i<s.length();i++) {
            if(i==0 && !Character.isDigit(s.charAt(i)) && s.charAt(i)!='e')
                return false;
            else if(!Character.isDigit(i)) {
                if(i!=s.length()-1) {
                    if(s.charAt(i)=='e' || s.charAt(i)=='.')
                        continue;
                    else
                        return false;
                }
                else 
                    if(s.charAt(i)!='e')
                        return false;
            }
            else
                continue;
            
        }
        return true;
    }
    public static void main(String[] args) {
    	isNumber("0");
    	
    }*/
}


/////////////////////////////////////////////////////////////////////////regex