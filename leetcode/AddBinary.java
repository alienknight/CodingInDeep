
public class AddBinary {
    public static String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = a.length()-1, n = b.length()-1;
        int sum=0, carry=0;
        int a_val, b_val;
        String res="";
        while(m>=0 || n>=0 || carry>0)
        {
            a_val=m>=0?a.charAt(m)-'0':0;
            b_val=n>=0?b.charAt(n)-'0':0;
            sum = a_val+b_val+carry;
            carry=sum/2;
            sum=sum%2;
            res = String.valueOf(sum).concat(res);
            m=m>=0 ?--m :m;
            n=n>=0 ?--n :n;
        }
        return res;
    }
    public static void main(String[] args) {
    	String a = "10110";
    	String b = "110";
    	System.out.println(addBinary(a,b));
    }
}
