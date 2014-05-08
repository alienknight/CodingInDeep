
public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long d1 = Math.abs((long)dividend), d2 = Math.abs((long)divisor);
        long res = 0;
        while(d1>=d2) {
            long temp = d2;
            for(int i=0;d1>=temp;temp<<=1,i++) {
                d1 = d1 - temp;
                res += 1<<i;
            }
        }
        return (dividend>0) ^ (divisor>0) ? (int)(0-res) : (int)res;
    }
    public static void main(String[] args) {
    	int a = Integer.MIN_VALUE, a2 = -1;
    	System.out.print(divide(a, a2));
    }
}
