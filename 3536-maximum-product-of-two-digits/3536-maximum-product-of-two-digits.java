class Solution {
    public int maxProduct(int n) {
        int largest=-1;
        int smallest=-1;
        while(n>0){
            int digit=n%10;
            if(digit>=largest){
                smallest=largest;
                largest=digit;
            }
            else if(digit>smallest){
                smallest=digit;
            }
            n/=10;
        }
        return largest*smallest;
    }
}