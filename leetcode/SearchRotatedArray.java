
public class SearchRotatedArray {
    public static int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length==0) return -1;
        return helper(A,0,A.length-1,target);
    }
    public static int helper(int[] A, int first, int last, int target) {
        if(first==last && A[first]!=target) return -1;
        int median = (first+last)/2;
        if(target==A[median]) return median;
        if(A[first]<=A[median])
        {
            if(target>=A[first]&&target<A[median])
                last = median-1;
            else
                first = median+1;
        }
        else
        {
            if(target>A[median]&&target<=A[last])
                first = median+1;
            else
                last = median-1;
        }
        return helper(A,first,last,target);
    }
    public static void main(String[] args){
    	int[] A = {5,1,3};
    	search(A,3);
    }
}
