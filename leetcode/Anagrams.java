import java.util.*;
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        if(strs==null || strs.length==0)
            return result;
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(map.containsKey(key))
                map.get(key).add(s);
            else
                map.put(key, new ArrayList<String>(Arrays.asList(s)));
        }
        for(ArrayList<String> list : map.values())
            if(list.size()>1)
                result.addAll(list);
        return result;
    }
}
