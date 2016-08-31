package offer_aimTo.Ch02;
/**
 * 
 * @author gyt
 * 
 * 二维数组是上下有序，左右有序，查找给定值是否在其中
 * 
 * 例如：
 *  1 2 8 9 
 *  2 4 9 12 
 *  4 7 10 13
 *  6 8 11 15
 *  
 *  思路：
 *  以7为例
 *  首先检查右上角，9，大于7，则这一列都不会有
 *  然后左移，8，大于7，这列也没有
 *  左移2，小于7，下移，4，下移7
 *  
 *  若为6 移到7之后，左移，4，再下移，6
 *  若为5，找到6之后结束，返回找不到
 *  
 *  还可以从左下角出发，但是不能从另外两个角出发
 *  
 *  局限：只能处理方阵
 *
 */
public class Ch02_FindTwoDe {
	
	public static void main(String[] args) {
		//the num to find
		int x = 9;
		int[][] twoDeArr  = {
			{1,2,8,9},	
			{2,4,9,12},
			{4,7,10,13},
			{6,8,11,15}
		};
		
		String resLoc;
		
		resLoc = findLoc(twoDeArr,x);
		
		System.out.println(resLoc);
	}

	private static String findLoc(int[][] twoDeArr, int x) {
		
		int i = 0,j = twoDeArr.length-1;
		
		while (i < twoDeArr.length && j >= 0) {
			if (twoDeArr[i][j] < x) {
				i++;
				continue;
			}else if (twoDeArr[i][j] > x) {
				j--;
				continue;
			}else {
				return i+ " \t" + j;
			}			
		};
		
		return "Cant Find.";
	}

}
