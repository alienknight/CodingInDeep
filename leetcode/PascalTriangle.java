import java.util.*;
public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows==0)
            return result;
        ArrayList<Integer> ini = new ArrayList<Integer> ();
        ini.add(1);
        result.add(ini);
        for(int i=1;i<numRows;i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for(int k=1;k<result.get(i-1).size();k++) {
                int sum = result.get(i-1).get(k-1) + result.get(i-1).get(k);
                temp.add(sum);
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
//    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        if(numRows<0)
//            return result;
//        ArrayList<Integer> r = new ArrayList<Integer>();
//        r.add(1);
//        result.add(r);
//        if(numRows==0)
//            return result;
//        for(int i=1;i<numRows;i++) {
//            ArrayList<Integer> t = new ArrayList<Integer>();
//            for(int j=0;j<=i;j++) {
//                if(j==0 || j==i)
//                    t.add(1);
//                else 
//                    t.add(result.get(result.size()-1).get(j-1)+result.get(result.size()-1).get(j));                    
//            }
//            result.add(t);
//        }
//        return result;
//    }
    public static void main(String[] args) {
    	generate(3);
    }
}
