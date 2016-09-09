package acmcoder;

import java.util.Scanner;

/**
 * 最多拦截的导弹数：
 * 导弹第一次能够达到任意的高度，以后每次都不会超过前一次的高度，求最多能拦截的导弹数。
 * eg:
 * 389 207 155 300 299 170 158 65
 * 则最多能拦截 389 300 299 170 158 65 ---> 6个导弹
 * @author Administrator
 *
 */

public class No4_LanjieDaodan {

	public static void main(String[] args) {
		
		Scanner sin = new Scanner(System.in);
		
		//输入组数
		int groupNum = sin.nextInt();
		
		int res = 0;
		
		for (int i = 0; i < groupNum; i++) {
			
			//每组的数据
			int caseNum = sin.nextInt();
			
			int[] caseArr = new int[caseNum];
			
			for (int j = 0; j < caseNum; j++) {
				caseArr[j] = sin.nextInt();
			}
			//对每组计算输出结果
			res = mostLanJieDaoDan(caseArr);
			System.out.println(res);
		}
	}

	private static int mostLanJieDaoDan(int[] caseArr) {
		
		return 0;
	}

}
