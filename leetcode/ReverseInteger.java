
public class ReverseInteger {
    public static int reverse(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        char[] num = Integer.toString(x).toCharArray();
        if(num[0]=='-')
        {
           for(int i=1;i<=num.length/2;i++)
            {
                char temp = num[i];
                num[i] = num[num.length-i];
                num[num.length-i] = temp;
            }
        }
        else
        {
            for(int i=0;i<=num.length/2;i++)
            {
                char temp = num[i];
                num[i] = num[num.length-i-1];
                num[num.length-i-1] = temp;
            }
        }
        return Integer.parseInt(num.toString());
    }
    public static void main(char[] args)
    {
    	int x = 0;
    	System.out.println(reverse(x));
    }
}


/*
public int reverse(int x) {
// Start typing your Java solution below
// DO NOT write main() function
if(x==0)
    return 0;
boolean pos = true;
if(x<0)
    pos = false;
x = Math.abs(x);
int res = 0;
while(x>0) {
    res = res*10 + x/10;
    x/=10;
}
return pos==true ? res : 0-res;
}
*/