import java.util.*;

public class qianzhui {
	public static String DALtoPN(String s) {
		if (s == null || s.length() == 0)
			return null;
		int i = s.length() - 1;
		String res = "";
		Stack<Character> stack = new Stack<Character>();
		while (i >= 0) {
			if (Character.isDigit(s.charAt(i)))
				res = s.charAt(i) + res;
			else {
				if (s.charAt(i) == '(') {
					while (stack.peek() != ')')
						res = stack.pop() + res;
					stack.pop();
				} else if (stack.isEmpty() || comp1(s.charAt(i), stack.peek()))
					stack.push(s.charAt(i));
				else {
					while (!stack.isEmpty()
							&& !comp1(s.charAt(i), stack.peek()))
						res = stack.pop() + res;
					stack.push(s.charAt(i));
				}
			}
			i--;
		}
		while (!stack.isEmpty())
			res = stack.pop() + res;
		return res;
	}

	public static boolean comp1(char a, char b) {
		// if((a=='*' || a=='/') && b==')') return false;
		if ((a == '+' || a == '-') && (b == '*' || b == '/'))
			return false;
		else
			return true;
	}

	public static int PN(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		if (s == null || s.length() < 0) {
			System.out.println("not valid");
			return -1;
		}
		int i = s.length() - 1;
		boolean valid = true;
		while (i >= 0) {
			if (!valid)
				break;
			if (Character.isDigit(s.charAt(i)))
				stack.push(Character.getNumericValue(s.charAt(i)));
			else {
				if (stack.size() < 2) {
					valid = false;
					continue;
				}
				int a = stack.pop();
				int b = stack.pop();
				if (s.charAt(i) == '+')
					stack.push(a + b);
				else if (s.charAt(i) == '-')
					stack.push(a - b);
				else if (s.charAt(i) == '*')
					stack.push(a * b);
				else if (s.charAt(i) == '/')
					stack.push(a / b);
				else
					valid = false;
			}
			i--;
		}
		if (valid && stack.size() == 1)
			return stack.pop();
		else {
			System.out.println("not valid");
			return -1;
		}
	}

	public static String DALtoRPN(String s) {
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
					while (!stack.isEmpty() && !comp(s.charAt(i), stack.peek()))
						res += stack.pop();
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

	public static int RPN(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		if (s == null || s.length() < 0) {
			System.out.println("not valid");
			return -1;
		}
		int i = 0;
		boolean valid = true;
		while (i < s.length()) {
			if (!valid)
				break;
			if (Character.isDigit(s.charAt(i)))
				stack.push(Character.getNumericValue(s.charAt(i)));
			else {
				if (stack.size() < 2) {
					valid = false;
					continue;
				}
				int a = stack.pop();
				int b = stack.pop();
				if (s.charAt(i) == '+')
					stack.push(a + b);
				else if (s.charAt(i) == '-')
					stack.push(b - a);
				else if (s.charAt(i) == '*')
					stack.push(a * b);
				else if (s.charAt(i) == '/')
					stack.push(b / a);
				else
					valid = false;
			}
			i++;
		}
		if (valid && stack.size() == 1)
			return stack.pop();
		else {
			System.out.println("not valid");
			return -1;
		}
	}
}
