import java.util.*;
public class LongestValidParentheses {
//    public int longestValidParentheses(String s) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(s.length()<=1) return 0;
//        int max = 0;        
//        int count = 0;
//        Stack<Character> stack = new Stack<Character>();
//        Stack<Integer> stack1 = new Stack<Integer>();
//        stack.push(s.charAt(0));
//        stack1.push(0);
//        for(int i=1;i<s.length();i++)
//        {            
//            if(s.charAt(i)=='(')
//            {
//                stack.push('(');
//                stack1.push(i);
//            }
//            if(s.charAt(i)==')')
//            {
//                if(!stack.isEmpty() && stack.peek()=='(')
//                {
//                    stack.pop();
//                    stack1.pop();
//                    if(stack1.isEmpty())
//                        count = i+1;
//                    else
//                        count = i - stack1.peek();
//                }
//                else 
//                {
//                    if(!stack.isEmpty())
//                        count = 0;
//                    stack.push(')');
//                    stack1.push(i);
//                }
//                max = count>max ? count : max;
//            }
//        }
//        return max;
//    }
//}


    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int max = 0, index = -1, i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(i<s.length()) {
            if(s.charAt(i)=='(')
                stack.push(i);
            else {
                if(stack.isEmpty())
                    index = i;
                else {
                    stack.pop();
                    max = Math.max(max,stack.isEmpty() ? i-index : i-stack.peek());
                }
            }
            i++;
        }
        return max;
    }