import java.util.HashMap;


public class SingleNumber2 {
//    public int singleNumber(int[] A) {
//        // Note: The Solution object is instantiated only once and is reused by each test case.
//        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int i=0;i<A.length;i++) {
//            if(map.containsKey(A[i]))
//                map.put(A[i],map.get(A[i])+1);
//            else
//                map.put(A[i],1);
//        }
//        for(int n : map.keySet())
//            if(map.get(n)==1)
//                return n;
//        return 0;
//    }
	public staitic int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int res = 0;
        int[] count = new int[32];
        for(int i = 0; i<32;i++) {
            for(int j=0;j<A.length;j++) {
                int temp = A[j]>>i & 1;
                count[i] = (count[i]+temp) % 3;
            }
            res += count[i]<<i;
        }
        return res;
    }
    public static int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int one = 0, two = 0, three = 0;
        for(int i=0;i<A.length;i++) {
            two |= one & A[i];
            one ^= A[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
    public static void main(String[] args) {
    	int[] a = {2,2,3,2};
    	singleNumber(a);
    }
}
