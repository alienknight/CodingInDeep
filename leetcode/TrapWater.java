public class TrapWater {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0) return 0;
        int i=0,j=A.length-1,h=0,volumn=0;
        while(i<j)
        {
            if(A[i]<A[j])
            {
                h=i+1;
                while(A[i]>A[h])
                {
                    volumn+=A[i]-A[h];
                    h++;
                }
                i=h;
            }
            else
            {
                h=j-1;
                while(A[j]>A[h])
                {
                    volumn+=A[j]-A[h];
                    h--;
                }
                j=h;
            }
        }
        return volumn;
    }
}
