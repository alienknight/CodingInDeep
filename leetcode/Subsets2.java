import java.util.*;
public class Subsets2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if(num==null || num.length==0) return res;
        Arrays.sort(num);
        int start = 0;
        for(int i=0;i<num.length;i++) {
            int size = res.size();
            int t = size;
            while(size-- > start) {
                ArrayList<Integer> temp = new ArrayList<Integer> (res.get(size));
                temp.add(num[i]);
                res.add(temp);
            }
            if(i<num.length-1 && num[i+1]==num[i]) start = t;
            else start = 0;
        }
        return res;
    }
//    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        result.add(new ArrayList<Integer>());
//        if(num.length==0)
//            return result;
//        Arrays.sort(num);
//        for(int i=0;i<num.length;i++) {
//            int j=result.size();
//            while(j-->0) {
//                ArrayList<Integer> b = new ArrayList<Integer>();
//                b.addAll(result.get(j));
//                b.add(num[i]);
//                if(!result.contains(b))
//                    result.add(b);
//            }
//        }
//        return result;
//    }
}
