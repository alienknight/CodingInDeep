import java.util.*;


public class LongestSubString {
	public class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(s.length() == 0)
	        {
	            return -1;
	        }
	        char[] target = s.toCharArray();
	        int max = 0;
//	        LinkedList list = new LinkedList(); 
	       //Stack ss = new Stack();ss.
	        for(int i = 0; i < target.length; i++)
	        {
	            int count = 0;
	            HashMap map = new HashMap();
	            for(int j = i; j < target.length; j++)
	            {
	                if(map.containsKey(target[j]))
	                {
	                    break;
	                }
	                else
	                {
	                    map.put(target[j], true);
	                    count++;
	                }
	            }
	            max = count>max ? count : max;
	        }
	        return max;
	    }
	}
}

/*
public int lengthOfLongestSubstring(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if(s.length()<=1)
        return s.length();
    HashMap<Character,Integer> map = new HashMap<Character,Integer>();
    int start = 0, max = 0;
    for(int i=0;i<s.length();i++) {
        if(!map.containsKey(s.charAt(i)) || map.get(s.charAt(i))<start)
            map.put(s.charAt(i),i);
        else {
            max = i-start>max ? i-start : max;
            start = map.get(s.charAt(i))+1;
            map.put(s.charAt(i),i);                
        }
    }
    max = s.length()-start>max ? s.length()-start : max;
    return max;
} 
*/