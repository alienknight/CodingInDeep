import java.util.Stack;


public class Zhongzhui {
    public static String DAL(String s) {
        if (s == null || s.length() == 0)
            return null;
        int i = 0;
        String res = "";
        Stack<Character> stack = new Stack<Character>();
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i)))
                res += s.charAt(i);
            else {
                if (s.charAt(i) == ')') {
                    while (stack.peek() != '(')
                        res += stack.pop();
                    stack.pop();
                } else if (stack.isEmpty() || comp(s.charAt(i), stack.peek()))
                    stack.push(s.charAt(i));
                else {
                    while (!comp(s.charAt(i), stack.peek())) {
                        res += stack.pop();
                        if (stack.isEmpty())
                            break;
                    }
                    stack.push(s.charAt(i));
                }
            }
            i++;
        }
        while (!stack.isEmpty())
            res += stack.pop();
        return res;
    }

    public static boolean comp(char a, char b) {
        if (a == '(')
            return true;
        else if ((a == '*' || a == '/') && (b == '+' || b == '-' || b == '('))
            return true;
        else if ((a == '+' || a == '-') && (b == '('))
            return true;
        else
            return false;
    }
}
