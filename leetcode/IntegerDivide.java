
public class IntegerDivide {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(divisor==0 || dividend==0) return 0;
        long dividend1 = Math.abs((long)dividend);//important
        long divisor1 = Math.abs((long)divisor);
        int count = 0;
        while(dividend1 >= divisor1)
        {
            long temp = divisor1;
            for(int i=0;dividend1>=temp;temp<<=1,i++)
            {
                dividend1-=temp;
                count+=1<<i;
            }
        }
        return (dividend>0)^(divisor>0) ? -count : count;
    } 
}
