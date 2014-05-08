import java.util.ArrayList;


public class MostContainer {
	public class Solution {
	    public int maxArea(int[] height) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int volume=0;
	        int i=0,j;
	        for(int iter = 0;iter<height.length;iter++,i++)
	        {
	            j=i+1;
	            for(int iter1 = iter+1;iter1<height.length;iter1++,j++)
	            {
	                int temp_vol = (j-i) * Math.min(height[iter],height[iter1]);
	                if(temp_vol > volume)
	                {
	                    volume = temp_vol;
	                }
	            }
	        }
	        return volume;
	    }
	}
}

/*
int maxArea(vector<int> &height) {
int i = 0;
int j = height.size() - 1;
int res = 0;
while(i < j)
{
    int temp = min(height[i], height[j]) * (j - i);
    if(temp > res)
        res = temp;
    if(height[i] <= height[j])
        i++;
    else
        j--;
}
return res;
}*/