import java.util.Stack;
import java.util.*;


public class MultiplyString {
 /*   public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num1.length()==0 || num2.length()==0)
            return "";
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        Stack<Integer> st = new Stack<Integer>();
        int carry = 0, count = num1.length()+num2.length()-2;
        helper(num1,num2,carry,st,count);
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty())
        {
            sb.append(String.valueOf(st.pop()));
        }
        return sb.toString();
    }
    public void helper(String num1, String num2, int carry, Stack<Integer> st, int count) {
        if(count<0) 
        {
            if(carry>0)
                st.push(carry);
            return ;
        }
        int temp = 0;
        for(int i=num1.length()-1, j=count-i;i>=0 && j<num2.length();i--,j++)
        {
            if(i<num1.length()&&j>=0)
                temp+=Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j));
        }
        temp = temp + carry;
        int sum = temp % 10;
        st.push(sum);
        carry = temp / 10;
        helper(num1,num2,carry,st,--count);
    }*/
    public static String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num1==null || num2==null || num1.length()==0 || num2.length()==0)
            return null;
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        ArrayList<String> mulres = new ArrayList<String>();
        mul(num1,num2,mulres,0);
        return add(mulres,mulres.get(0),1);
    }
    public static void mul(String num1,String num2,ArrayList<String> mulres,int index) {
        if(index>=num2.length())
            return ;
        String sb = "";
        int a = Character.getNumericValue(num2.charAt(index));
        int carry = 0;
        for(int i=num1.length()-1;i>=0;i--) {
            int temp = Character.getNumericValue(num1.charAt(i)) * a;
            temp += carry;
            sb = String.valueOf(temp%10) + sb;
            carry = temp/10;
        }
        if(carry!=0)
            sb = String.valueOf(carry) + sb;
        mulres.add(sb);
        mul(num1,num2,mulres,index+1);        
    }
    public static String add(ArrayList<String> mulres, String s1, int index) {
        if(index>=mulres.size())
            return s1;
        String sb = s1.substring(s1.length()-index,s1.length());
        String s2 = mulres.get(index);
        int carry = 0;
        for(int i=s2.length()-1;i>=0;i--) {
            if(s2.length()-1-i+index>=s1.length())
                sb = String.valueOf(Character.getNumericValue(s2.charAt(i))+carry) + sb;
            else {
                int temp = Character.getNumericValue(s2.charAt(i)) + Character.getNumericValue(s1.charAt(s2.length()-1-i+index));
                carry = temp/10;
                sb = String.valueOf(temp%10) + sb;
            }
        }
        if(carry!=0)
            sb = String.valueOf(carry) + sb;
        return add(mulres,sb,index+1);
    }
    public static void main(String[] args) {
    	String s1 = "9";
    	String s2 = "99";
    	multiply(s1,s2);
    }
}
