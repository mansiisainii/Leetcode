class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(isGood(i)){
                count++;
            }
        }
                    return count;
    }
    public boolean isGood(int num){
        boolean changed=false;
        while(num>0){
            int n=num%10;
            if(n==3||n==4||n==7)return false;
            if(n==2||n==5||n==6||n==9){
                changed=true;
            }
            num/=10;

        }
        return changed;
    }
}