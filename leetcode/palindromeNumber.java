    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0)
            return false;
        if(x==0)
            return true;
        int r=0, s=x;
        while(x>0) {
            r = r*10 + x%10;
            x /= 10;
        }
        return r==s ? true : false;
    }