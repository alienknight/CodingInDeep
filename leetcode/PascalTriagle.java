import java.util.*;
public class PascalTriagle {

    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if(rowIndex==0)
            return result;
        result.add(1);
        if(rowIndex==1)
            return result;
        for(int i=2;i<=rowIndex;i++) {
            result.add(1,i);
            for(int j=2;j<result.size()-1;j++) {
                result.set(j,result.get(j)+result.get(j+1));
            }
        }
        return result;
    }
//public static ArrayList<Integer> getRow(int rowIndex) {
//    ArrayList<Integer> resultList = new ArrayList<Integer>();
//    if (rowIndex == 0) {
//        resultList.add(1);
//        return resultList;
//    }
//    // Initial
//    resultList.add(1);
//    resultList.add(1);
//
//    for (int i = 2; i <= rowIndex; i++) {
//        resultList.add(1, resultList.get(0) + resultList.get(1));       
//        for (int j = 2; j < resultList.size() - 1; j++) {
//            resultList.set(j, resultList.get(j) + resultList.get(j + 1));
//        }
//    }
//
//    return resultList;
//}


    public static void main(String[] args) {
    	getRow(4);
    }
}


