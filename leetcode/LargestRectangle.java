
public class LargestRectangle {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length==0)    
            return 0;
        int result = 0;
        for(int i=0;i<height.length;i++)
            for(int j=i;j<height.length;j++) {
                int temp = min(height,i,j);
                int rec = temp * (j-i+1);
                result = rec>result ? rec : result;
            }
        return result;
    }
    public int min(int[] height, int begin, int last) {
        int temp = Integer.MAX_VALUE;
        for(int i=begin;i<=last;i++) {
            temp = height[i]<temp ? height[i] : temp;
        }
        return temp;
    }
}

/////////////////////////////////////////So Elegant!!!
/*
public int largestRectangleArea(int[] height) {
// Start typing your Java solution below
// DO NOT write main() function
Stack<Integer> stack = new Stack<Integer>();
int i = 0, max = 0;
while(i<=height.length) {
    if(stack.isEmpty() || height[stack.peek()] <= (i<height.length ? height[i] : 0))
        stack.push(i++);
    else {
        int temp = stack.pop();
        max = Math.max(max, height[temp] * (stack.isEmpty() ? i : i-stack.peek()-1));
    }
}
return max;
}
*/