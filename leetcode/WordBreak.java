import java.util.*;
public class WordBreak {
//    public boolean wordBreak(String s, Set<String> dict) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        if(s==null || s.length()==0)
//            return true;
//        boolean judge = false;
//        for(int i=0;i<=s.length();i++) {
//            if(dict.contains(s.substring(0,i)))
//                judge |= wordBreak(s.substring(i,s.length()),dict);
//        }
//        return judge;
//    }
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s==null)
            return true;
        boolean[] judge = new boolean[s.length()+1];
        judge[0] = true;
        for(int i=1;i<=s.length();i++)
            for(int j=0;j<i;j++)
                if(judge[j] && dict.contains(s.substring(j,i)))
                    judge[i] = true;
        return judge[s.length()];
    }
}
