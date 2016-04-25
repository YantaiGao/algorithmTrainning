package LeetCode;

/**
 *
 * @author Administrator
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 *
 */

public class Num1TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,3,7};
		int target = 5;
		twoSum(nums,target);
		
	}
	
	    public static int[] twoSum(int[] nums, int target) {
	        
	    	int[] a = new int[2];
	        
	        int remain;
	        
	        for(int i = 0; i < nums.length; i++){
	        	
	            a[0] = i;
	            
	            remain = target - nums[i];
	            
	            int j = i+1;
	            
	            while (j < nums.length) {
	            	if (remain == nums[j]) {
						a[1] = j;
						return a;
					}
	            	j++;
				}
	        }
	        return a;
	    }
}
