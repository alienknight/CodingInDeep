public class LengthofLastWord {
	public static int lengthOfLastWord(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0)
			return 0;
		String[] a = s.split(" ");
		if (a.length == 0)
			return 0;
		return a[a.length - 1].length();
	}

	public static void main(String[] args) {
		String s = " ";
		lengthOfLastWord(s);
	}
}
