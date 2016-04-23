package LeetCode;

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
