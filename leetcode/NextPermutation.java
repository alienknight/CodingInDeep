import java.util.*;
public class NextPermutation {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length==0 || num.length==1) return;
        for(int i=num.length-1;i>=1;i--)
        {
            if(num[i]<=num[i-1])
                continue;
            else
            {
                for(int j=num.length-1;j>=i;j--)
                {
                    if(num[j]>num[i-1])
                    {
                        int temp = num[j];
                        num[j] = num[i-1];
                        num[i-1] = temp;
                        Arrays.sort(num,i,num.length);
                        return;
                    }
                    continue;
                }
            }
        }
        Arrays.sort(num);
        return ;
    }
}

/*
public void nextPermutation(int[] num) {
    if(num == null) return;
    int i = num.length - 2;
    while(i >= 0 && num[i] >= num[i + 1]) i--;
    for(int j = num.length - 1; i >= 0 && j > i; j--)
        if(num[j] > num[i]){
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            Arrays.sort(num, i + 1, num.length);
            return;
        }
    Arrays.sort(num);
}*/