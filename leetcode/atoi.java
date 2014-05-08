
public class atoi {
	public static int atoi(String str) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	    str = str.trim();
	    String s = "";
	    for(int i=0;i<str.length();i++) {
	        if(i==0 && (str.charAt(i)=='-' || str.charAt(i)=='+'))
	            s = s+str.charAt(i);
	        else if(i>=0 && (str.charAt(i)-'0'<0 || str.charAt(i)-'0'>9))
	            break;
	        else
	            s = s+str.charAt(i);
	    }
	    if(s.length()==0 || s.equals("+") || s.equals("-"))
	        return 0;
	    if(s.length()>10 && (s.charAt(0)!='-' && s.charAt(0)!='+') || s.length()>11) {
	        if(s.charAt(0)!='-')
	            return Integer.MAX_VALUE;
	        else
	            return Integer.MIN_VALUE;
	    }
	    long temp=0;
	    if(s.charAt(0)=='+')
	        temp = Long.parseLong(s.substring(1));
	    else
	        temp = Long.parseLong(s);
	            
	    if(temp>Integer.MAX_VALUE)
	        return Integer.MAX_VALUE;
	    else if(temp<Integer.MIN_VALUE)
	        return Integer.MIN_VALUE;
	    else {
	        if(s.charAt(0)=='+')
	            return Integer.parseInt(s.substring(1));
	        else
	            return Integer.parseInt(s);
	    }
	} 
	public static void main(String[] args) {
		String a = "3   21";
		atoi(a);
	}
}

/*


class Solution {
public:
    int atoi(const char *str) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
        assert(str != NULL);
        if (*str == '\0') return 0;
  
        const char *p = str;
        int minus = 1;
  
        //skip spaces
        while (*p == ' ') p++;
  
        //get sign
        if (*p == '-') {
            minus = -1;
            p++;
        } else if (*p == '+') {
            minus = 1;
            p++;
        }
  
        //convert numbers
        int num = 0;
        while (isdigit(*p)) {
            if ( ((num == 214748364) && (((*p) - '0') > 7)) || (num > 214748364) ) {
                return (minus > 0) ? INT_MAX : INT_MIN;
            }
            num = 10*num + ((*p) - '0');
            p++;
        }
  
        return (minus > 0) ? num : -num;        
    }
};
  
*/
