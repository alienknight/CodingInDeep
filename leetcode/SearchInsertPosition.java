
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0) return -1;
        return helper(A,target,0,A.length-1);
    }
    public int helper(int[] A, int target, int begin, int end) {
        if(begin>=end) 								//Important >=
        {
            if(target<=A[begin])					//Important
                return begin;
            else
                return begin+1;
        }
        int median = (begin+end)/2;
        if(target==A[median]) return median;
        if(target>A[median]) 
        {
            if(median==A.length-1)					//Important
                return A.length;
            begin = median+1;
        }
        else
        {
            if(median==0)
                return 0;
            end = median-1;
        }
        return helper(A,target,begin,end);
    }
}
