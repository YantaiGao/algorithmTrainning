package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Num1TwoSumVersion2 {

	public static void main(String[] args) {
		int[] nums = {2,3,7};
		int target = 5;
		int[] res = twoSum(nums,target);
		for (int i : res) {
			System.out.print(i + "\t");
		}
	}
	private static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> hashMap = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(target - nums[i])) {
				result[0] = i;
				result[1] = i+1;
				return result;
			}
			hashMap.put(nums[i], i);
		}
		return result;
	}
}
