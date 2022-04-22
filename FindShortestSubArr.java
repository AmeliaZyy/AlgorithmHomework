/*
给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

 

来源：力扣（LeetCode）697
链接：https://leetcode-cn.com/problems/degree-of-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

class FindShortestSubArray{
    public int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i])[0]++;
                map.get(nums[i])[2]=i;
            }else{
                map.put(nums[i], new int[]{1,i,i});
            }
        }

        int times=0, minLen=0;
        for(Map.Entry<Integer,int[]> entry:map.entrySet()){
            int arr[] = entry.getValue();//第一次写成了map.get(entry)...
            if(times<arr[0]){
                times=arr[0];
                minLen=arr[2]-arr[1]+1;
            }else if(times == arr[0]){
                if(minLen>arr[2]-arr[1]+1){
                    minLen=arr[2]-arr[1]+1;
                }
            }
        }
        return minLen;
    }
}