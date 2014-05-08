import java.util.*;
public class PhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String> ();
        String[] s = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(digits.length()==0) 
        {
            result.add("");
            return result;
        }
        return helper(digits,result,s,0);
    }
    public ArrayList<String> helper(String digits, ArrayList<String> result, String[] s, int index)
    {
        if(index==digits.length()) return result;
        ArrayList<String> result1 = new ArrayList<String> ();
        int a = Character.getNumericValue(digits.charAt(index));
        String temp = s[a-2];
        for(int i=0;i<temp.length();i++)
        {
            if(result.size()==0)
                result1.add(String.valueOf(temp.charAt(i)));
            else
            for(int j=0;j<result.size();j++)
            {
                String t = result.get(j).concat(String.valueOf(temp.charAt(i)));
                result1.add(t);
            }
        }
        return helper(digits,result1,s,index+1);
    }
}
