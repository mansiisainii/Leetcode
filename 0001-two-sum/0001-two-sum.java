class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int a = nums[i];
            int diff=target-a;
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(a,i);
        }
        return new int[]{};
    }
}