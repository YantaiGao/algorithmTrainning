package acmcoder;

import java.util.Scanner;

/**
 * 问题描述：
 * 为了鼓励宝宝数数：
 * 买了n个玩具，从 1到n顺序排列，
 * 数数规则是：1 2...n,然后下一个是n-1号玩具，数为n+1
 * eg：3个玩具
 * 数数：		1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 ... 
 * 玩具编号：	1 2 3 2 1 2 3 2 1 2  3  2  1  2  3  2  1  2  3  2  1...
 * 每当宝宝数到7 或者7的倍数，或者包含7的数，爸爸都要鼓掌
 * 给定：n,m,k
 * 求x
 * n为玩具总数，m为编号m的玩具，k为编号m玩具遇到爸爸的第k次掌声
 * x为宝宝此时实际已经数到了几。
 * 
 * @author lenovo
 *
 */
public class No2_CountToys {

	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		while (true) {
			int n = sin.nextInt();
			int m = sin.nextInt();
			int k = sin.nextInt();
			if (n==0 && m==0 && k==0) {
				break;
			}
			No2_CountToys toys = new No2_CountToys();
			int res = toys.numInFact(n,m,k);
			System.out.println(res);
		}
	}
	/**
	 * 思路：
	 * 对于玩具m：
	 * 从1开始计算m出现时实际数的数，
	 * 判断这个数是不是需要鼓掌,
	 * 需要鼓掌，则countTime次数+1
	 * 直到次数为k，返回x
	 * 
	 * (1)首先需要确定一个轮回的长度 L = 2*n - 2
	 * (2)求出m在第一轮回中的编号-即实际的数
	 * 	若是m为1或者n，则有一个编号；
	 * 	否则有两个编号
	 * (3)依次求出下一轮中的实际的数，一个或者两个
	 * (4)并判断是否鼓掌,直至k次
	 * 
	 * 长度为1需要单独处理
	 * 
	 */
	private int numInFact(int n, int m, int k) {
		//输入违法
		if (m > n) {
			return -1;
		}
		//鼓掌次数
		int temp = 0;
		//实际的数
		int infactNum = 0;
		//第二个下标，只有m不是1和n的时候会用到
		int indexTwo = 0;
		//一个round的长度
		int roundLen = 0;
		//一个玩具
		if (n==1 && m==1) {
			infactNum = 0;
			roundLen = 1;
		}else {
			//除了n=1之外，一个轮回长度
			roundLen = 2*n-2;
			//首尾数1，或者n在一个轮回中只出现一次，首次序号就是m
			if (m == 1 || m == n) {
				//roundOne轮回中只有一个数字，infactNum = m
				//roundOne中序号是m
				infactNum = m;
			}else {
				infactNum = m;
				indexTwo = n + (n-m);
			}
		}
		
		while (temp != k) {
			//数字1需要单独处理
			if(n == 1 && m == 1){
				//符合条件
				if (infactNum % 7 == 0 || new Integer(infactNum).toString().indexOf("7") >= 0) {
					temp++;
				}
				infactNum = infactNum + roundLen;
			}else if (m == 1 || m == n) {
				//roundOne轮回中只有一个数字，infactNum = m
				//符合条件
				if (infactNum % 7 == 0 || new Integer(infactNum).toString().indexOf("7") >= 0) {
					temp++;
				}
				infactNum = infactNum + roundLen;
			}else {
				//一个玩具在一个roundOne中出现两次，两次都要判断
				//符合条件
				if (infactNum % 7 == 0 || new Integer(infactNum).toString().indexOf("7") >= 0) {
					temp++;
				}
				infactNum = infactNum + roundLen;
				if (indexTwo % 7 == 0 || new Integer(indexTwo).toString().indexOf("7") >= 0) {
					temp++;
				}
				indexTwo = indexTwo + roundLen;
			}
		}
		return infactNum;
	}
}
