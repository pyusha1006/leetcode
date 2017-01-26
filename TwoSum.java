
/*
 * Given an array of integers, return indices of the two numbers such that they add up to a
 * specific target.

	You may assume that each input would have exactly one solution.
	
  Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/




public class Solution {
    public int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
	    	int sum = 0;
	        for(int i = 0 ;i < nums.length ; i++){
	        	int temp = nums[i];
	        	for(int j= 0 ;j< nums.length; j++){
	        		if( j != i){
	        		sum = temp + nums[j];
		        	if(sum == target)
		        	{
		        		result[0] = i;
		        		result[1] = j;
		        		if(i > j){
		        		    int swap = result[1];           // ignoring the case when result{2,1} comes instaed of {1,2}
		        		    result[1] = result[0];
		        		    result[0] = swap;
		        		}
		        		break;
		        	}	
	        		}
	        	}
	        	
	        
	        } 
	        return result;
	    }
}
	    
