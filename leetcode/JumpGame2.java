
public class JumpGame2 {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int cur=A[0];
        if(A.length==0) return true;
        for(int i=0;i<A.length;i++)
        {
            if(i>cur)
                return false;
            cur = Math.max(cur,A[i]+i);
        }
        return true;
    }
}
