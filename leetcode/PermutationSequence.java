import java.util.*;
import java.io.*;
public class PermutationSequence {
//    public static String getPermutation(int n, int k) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        if(n==0 || k==0) return "0";
//        ArrayList<Integer> a = new ArrayList<Integer>();
//        for(int i=1;i<=n;i++)
//            a.add(i);
//        int result=0, count=n;
//        for(int i=0;i<=count-1;i++)
//        {
//            int num = 1;
//            while(k>factor(n-1))
//            {
//                num++;
//                k = k-factor(n-1);
//            }
//            n--;
//            result = result*10+a.get(num-1);
//            a.remove(num-1);
//        }
//        return String.valueOf(result);
//    }
//    public static int factor(int n) {
//        int temp=1;
//        while(n>0)
//        { 
//            temp = temp * n;
//            n--;
//        }
//        return temp;
//    }
//    public static void main(String[] args) {
//    	int n=4, k=19;
//    	System.out.print(getPermutation(n,k));
//    }
	public String getPermutation(int n, int k) {
	    // Note: The Solution object is instantiated only once and is reused by each test case.
	    ArrayList<Integer> store = new ArrayList<Integer> ();
	    int[] fact = new int[n+1];
	    fact[0] = 1;
	    for(int i=1;i<=n;i++) {
	        store.add(i);
	        fact[i] = fact[i-1] * i;
	    }
	    String res = "";
	    k--;
	    for(int i=n-1;i>=0;i--) {
	        int r = k / fact[i];
	        res += store.get(r);
	        store.remove(r);
	        k %= fact[i];
	    }
	    return res;
	}
}

