import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(path.length()==0 || path==null)
            return "/";
        String[] store = path.trim().split("/");
        Stack<String> stack = new Stack<String>();
        for(String s : store) {
            if(s==null || s.length()==0 || s.equals("."))
                ;
            else if(s.equals("..")) {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else {
                stack.push(s);
            }
        }
        if(stack.isEmpty())								// Important
            return "/";
        StringBuffer st = new StringBuffer();
        while(!stack.isEmpty()) {
            st.insert(0,stack.pop());
            st.insert(0,"/");
        }
        return st.toString();
    }
}
