class Solution {
    public long gcdSum(int[] nums) {
        int n= nums.length;
        int prefix[]=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(nums[i],max);
            prefix[i]=gcd(nums[i],max);
        }
        Arrays.sort(prefix);
        long ans=0;
        int left=0,right=n-1;
        while(left<right){
            ans+=gcd(prefix[left], prefix[right]);
            left++;
            right--;
        }
        return ans;
    }
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}