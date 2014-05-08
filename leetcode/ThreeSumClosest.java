import java.util.*;
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length<3) return 0;
        Arrays.sort(num);
        int result = Integer.MAX_VALUE;
        int label=333;
        for(int i=0;i<num.length;i++)
        {
            int m=i+1;
            int n=num.length-1;
            while(m<n)
            {
                int temp=num[i]+num[m]+num[n];
                int r=Math.abs(temp-target);
                if(r<result)
                {
                    result = r;
                    label = temp;
                    if(temp < target)
                        m++;
                    else
                        n--;
                }
                else if(temp<target)
                    m++;
                else
                    n--;
            }
        }
        return label;        
    }
}

//public int threeSumClosest(int[] num, int target) {
//// Start typing your Java solution below
//// DO NOT write main() function
//if(num.length<3)
//    return -1;
//Arrays.sort(num);
//int close = num[0]+num[1]+num[2];
//for(int i=0;i<num.length-2;i++) {
//    if(i>0 && num[i]==num[i-1])
//        continue;
//    int j = i+1;
//    int k = num.length-1;
//    while(j<k) {
//        if(num[j]+num[k]==target-num[i]) 
//            return target;
//        else if(num[j]+num[k]<target-num[i]) {
//            close = Math.abs(target-close)<target-(num[i]+num[j]+num[k]) ? close : num[i]+num[j]+num[k];
//            j++;
//        }
//        else {
//            close = Math.abs(target-close)<(num[i]+num[j]+num[k])-target ? close : num[i]+num[j]+num[k];
//            k--;
//        }
//    }
//}
//return close;
//}