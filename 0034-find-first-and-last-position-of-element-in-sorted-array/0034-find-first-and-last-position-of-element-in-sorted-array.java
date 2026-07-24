class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx1=-1,idx2=-1;
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]>target){
                h=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                idx1=mid;
                h=mid-1;
            }
        }
        l=0;
         h=nums.length-1;
         while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]>target){
                h=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else{
                idx2=mid;
            l=mid+1;
            }
        }
        return new int[]{idx1,idx2};
    }
}