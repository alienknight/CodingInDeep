import java.util.*;
public class ValidParentheses {
	 public static boolean isValid(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(s.length()==0) return true;//Stack x = new Stack();
	        int ml=0,mr=0,nl=0,nr=0,pl=0,pr=0;//LinkedList x = new LinkedList();
	        for(int i=0;i<s.length();i++)//ArrayList x = new ArrayList(); x
	        {
	            switch(s.charAt(i)){
	                case '(': ml++; break;
	                case ')': mr++; break;
	                case '[': nl++; break;
	                case ']': nr++; break;
	                case '{': pl++; break;
	                case '}': pr++; break;
	                default: return false;
	            }
	            if(i==0) continue;
                if(mr>ml || nr>nl || pr>pl || (mr==ml && mr>0 && nl>nr && s.charAt(i-1)=='[' && s.charAt(i)==')') || (mr==ml && mr>0 && pl>pr && s.charAt(i-1)=='{' && s.charAt(i)==')') || (nr==nl && nr>0 && ml>mr && s.charAt(i-1)=='(' && s.charAt(i)==']') || (nr==nl && nr>0 && pl>pr && s.charAt(i-1)=='{' && s.charAt(i)==']') || (pr==pl && pr>0 && ml>mr && s.charAt(i-1)=='(' && s.charAt(i)=='}') || (pr==pl && pr>0 && nl>nr && s.charAt(i-1)=='[' && s.charAt(i)=='}'))
	                return false;
	        }
	        if(ml==mr && nl==nr && pl==pr)
	            return true;
	        else
	            return false;
	    }
	 public static void main(String[] args){
		 String s = "[({(())}[()])]";
		 System.out.println(isValid(s));
	 }
}
/*


class Solution 
{
public:
bool isValid(string s) 
  {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    int n = s.size();
    stack<char> st;
    st.push(s[0]);
    for( int i=1;i<n;i++)
    {
        char tmp = s[i];
        if( tmp == ')')
                {
                    if( !st.empty() && st.top() == '(')
                        st.pop();
                    else 
                        return false;
                }
        else if( tmp == ']')
                {
                    if( !st.empty() && st.top() == '[')
                        st.pop();
                    else 
                        return false;
                }
        else if( tmp == '}')
                {
                    if( !st.empty() && st.top() == '{')
                        st.pop();
                    else 
                        return false;
                }
        else
            st.push(s[i]);
    }
    return st.empty() ? true:false;
  }
};
*/