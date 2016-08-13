package LeetCode;

public class Num3LongestSubstringWithoutRepeating {

	public static void main(String[] args) {

		String string = "pwwkew";
		string = "bbbbbbbbbbb";
		string = "abcabcda";
		string = "abcabd";
		string = "";
		string = "c";
		string = "dvdf";
		
		string = "anviaj";
		
		
		System.out.println("len = " + lengthOfLongestSubstring(string));
		
	}


	public static int lengthOfLongestSubstring(String s) {
        
		//用来记录最长的串长
		int max = 0;
        //将string转为char数组
		char[] arr = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		int j  = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sb.indexOf((String.valueOf(arr[i]))) < 0) {
				sb.append(arr[i]);
				j++;
			}else {
				if (j > max) {
					max = j;
				}
				if (arr[i] != sb.charAt(sb.length()-1)) {
					
					sb = sb.delete(0, sb.length()-1);
					sb.append(arr[i]);
					j = 2;
					
				}else {
					sb = new StringBuffer();
					sb.append(arr[i]);
					j = 1;
				}
			}
		}
		if (j > max) {
			max = j;
		}
		return max;
    }
}
