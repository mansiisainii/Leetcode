class Solution {
    public boolean isPalindrome(int x) {
        int m=x;
        int rev=0;
        int rem;
        while(x>0){
            rem = x%10;
            rev=(rev*10)+rem;
            x/=10;
        }
        if(m==rev){
            return true;
        }
        return false;
    }
}