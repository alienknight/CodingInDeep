
public class sqrt {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<=1) return x;
        int left=0, right=x;
        while(right-left>1)						//if[a,a+1] will always be a (cannot be a+1, since it comes from mid)
        {
            int mid = left+(right-left)/2;
            if(mid==x/mid)
                return mid;
            else if(mid<x/mid)
                left = mid;
            else
                right = mid;
        }
        return left;
    }
}
