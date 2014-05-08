public class PlusOne {
	public int[] plusOne(int[] digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int i = digits.length - 1;
		while (i >= 0) {
			if (digits[i] != 9) {
				digits[i] += 1;
				return digits;
			} else
				digits[i] = 0;
			i--;
		}

		int[] res = new int[digits.length + 1];
		res[0] = 1;
		for (int k = 0; k < digits.length; k++)
			res[k + 1] = digits[k];
		return res;

	}

}
