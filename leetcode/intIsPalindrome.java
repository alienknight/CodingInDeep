
public class intIsPalindrome {
	public class Solution {
	    public boolean isPalindrome(int x) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int temp = x;
	        int test = 0;
	        while(temp>0)
	        {
	            int a = temp % 10;
	            test = test * 10 + a;
	            temp /= 10;
	        }
	        if(test==x)
	            return true;
	        else
	            return false;
	    }
	}
}
