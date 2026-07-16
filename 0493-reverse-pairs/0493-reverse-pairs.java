class Solution {
    public void merge(int a[],int l,int h,int mid){
        int merged[]=new int[h-l+1];
        int idx1=l;
        int idx2=mid+1;
        int x=0;
        while(idx1<=mid && idx2<=h){
            if(a[idx1]<=a[idx2]){
                merged[x++]=a[idx1++];
            }
            else{
                merged[x++]=a[idx2++];
            }
           
        }
        while(idx1<=mid){
           merged[x++]=a[idx1++]; 
        }
        while(idx2<=h){
             merged[x++]=a[idx2++];
        }
         for(int i=0;i<merged.length;i++){
                a[i+l]=merged[i];
            }
    }
    public int countPairs(int a[],int l,int h,int mid){
        int right=mid+1;
        int count=0;
        for(int i=l;i<=mid;i++){
            while(right<=h && a[i]>2L*a[right]){
                right++;
            }
            count+=right-(mid+1);
        }
        return count;
    }
    public int mergeSort(int a[],int l,int h){
        int count=0;
        if(l>=h)return 0;
        int mid=l+(h-l)/2;
        count+=mergeSort(a,l,mid);
        count+=mergeSort(a,mid+1,h);
        count+=countPairs(a,l,h,mid);
        merge(a,l,h,mid);
        return count;
    }
    public int reversePairs(int[] nums) {
     int n=nums.length; 
     return mergeSort(nums,0,n-1);
    }
}