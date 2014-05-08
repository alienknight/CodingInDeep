import java.util.*;

//////////////////////Not Sure
public class SubstringConcatenation {
//    public static ArrayList<Integer> findSubstring(String S, String[] L) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        ArrayList<Integer> result = new ArrayList<Integer> ();
//        if(L.length==0 || S.length()==0)
//            return result;
//        Arrays.sort(L);
//        int leng = L.length * L[0].length();
//        for(int j=0;j<S.length()-leng+1;j++)
//        {
//            String T = S.substring(j,j+leng);
//            for(int k=0;k<L.length;k++)
//            {
//                if(!T.contains(L[k]))
//                    break;
//                T = T.replaceFirst(L[k],"\0");
//                if(k==L.length-1)
//                    result.add(j);
//            }
//        }
//        return result;
//    }
    

/*
public ArrayList<Integer> findSubstring(String S, String[] L) {
// Start typing your Java solution below
// DO NOT write main() function
ArrayList<Integer> result = new ArrayList<Integer> ();
if(L.length==0 || S.length()==0)
    return result;
int leng = L.length * L[0].length();
HashMap<String, Integer> map = new HashMap<String, Integer>();
for(int i=0;i<L.length;i++) {
    if(map.containsKey(L[i]))
        map.put(L[i],map.get(L[i])+1);
    else
        map.put(L[i],1);
}
for(int j=0;j<S.length()-leng+1;j++)
{
    HashMap<String, Integer> temp = new HashMap<String, Integer>(map);
    int count=j;
    while(true) {
        String s = S.substring(count,count+L[0].length());
        if(temp.containsKey(s)) {
            if(temp.get(s)!=1)
                temp.put(s,temp.get(s)-1);
            else 
                temp.remove(s);
            if(temp.isEmpty()) {
                result.add(j);
                break;
            }
            count += L[0].length();
        }
        else
            break;
    }
}
return result;
}*/


public static ArrayList<Integer> findSubstring(String S, String[] L) {
// Note: The Solution object is instantiated only once and is reused by each test case.
ArrayList<Integer> res = new ArrayList<Integer>();
if(S==null || L==null || L.length==0||S.length()<L.length*L[0].length()) return res;
int m = S.length(), n = L.length, len = L[0].length();
List<String> list = new ArrayList<String>(Arrays.asList(L));
for(int i=0;i<=m-n*len;i++)
    if(isFind(S.substring(i,i+n*len),list,len))
        res.add(i);
return res;
}
public static boolean isFind(String S, List<String> list, int len) {
ArrayList<String> temp = new ArrayList<String>(list);
for(int i=0;i<S.length();i+=len) {
    if(temp.contains(S.substring(i,i+len))) 
        temp.remove(temp.indexOf(S.substring(i,i+len)));
    else 
        return false;
}
return true;
}
}