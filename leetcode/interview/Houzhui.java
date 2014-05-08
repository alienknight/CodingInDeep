import java.util.*;

public class Houzhui {
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

	// public static void main(String[] args) {
	// String s = "5+(1+2)*4-3";
	// System.out.print(RPN(DAL(s)));
	// }
}
