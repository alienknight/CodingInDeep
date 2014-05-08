
public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int first=-1, last=-1;
        int[] none = {-1,-1};
        if(A.length==0) return none;
        first=helperf(A,target,0,A.length-1);
        last=helperl(A,target,0,A.length-1);
        int[] result = {first,last};
        return result;
    }
    public int helperf(int[] A,int target,int start,int end)
    {
        if(start>end) return -1;
        int median=(start+end)/2;
        if(target==A[median] && (median==0 || target>A[median-1])) return median;
        if(target<=A[median])
            end = median-1;
        else
            start = median+1;
        return helperf(A,target,start,end);
    }
    public int helperl(int[] A,int target,int start,int end)
    {
        if(start>end) return -1;
        int median=(start+end)/2;
        if(target==A[median] && (median==A.length-1 || target<A[median+1])) return median;
        if(target>=A[median])
            start = median+1;
        else
            end = median-1;
        return helperl(A,target,start,end);
    }
}
