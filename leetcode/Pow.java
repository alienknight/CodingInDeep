
public class Pow {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0)
            return 1;
        if(x==0)
            return 0;
        double mul = 1.00;
        for(int i=0;i<Math.abs(n);i++)
        {
            mul*=x;
        }
        mul = n>0?mul:1/mul;
        return mul;
    }
}
/*
double pow(double x, int n) {
    if (n == 0) return 1.0;
    // Compute x^{n/2} and store the result into a temporary
    // variable to avoid unnecessary computing
    double half = pow(x, n / 2);
    if (n % 2 == 0)
        return half * half;
    else if (n > 0)
        return half * half * x;
    else
        return half * half / x;
}*/