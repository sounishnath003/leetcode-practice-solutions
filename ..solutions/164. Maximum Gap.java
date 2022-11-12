class Solution {
 public int maximumGap(int[] nums) {
    
      if(nums.length<2)return 0;
      int min = nums[0] , max = 0;
    
      for(int num : nums){
          min = Math.min(min,num);
          max = Math.max(max,num);
      }
      
      int interval = (int)Math.ceil((max-min+0.0)/(nums.length-1));
    
      int[] bucketMin = new int[nums.length-1];
      int[] bucketMax = new int[nums.length-1];
      
      Arrays.fill(bucketMin,Integer.MAX_VALUE);
      Arrays.fill(bucketMax,-1);
      
      for(int i=0;i<nums.length;i++){
          if(nums[i]==min || nums[i]==max)continue;
          
          int index = (nums[i]-min)/interval;
          bucketMin[index] = Math.min(bucketMin[index],nums[i]);
          bucketMax[index] = Math.max(bucketMax[index],nums[i]);
      }
        
      int prev = min;
      int maxGap = 0;
      for(int i=0;i<bucketMin.length;i++){
          if(bucketMax[i]==-1)continue;
          maxGap = Math.max(bucketMin[i]-prev,maxGap);
          prev = bucketMax[i];
      }
      maxGap = Math.max(max-prev,maxGap);
      
      return maxGap;
    }
}
