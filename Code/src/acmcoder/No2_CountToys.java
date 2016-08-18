package acmcoder;

import java.util.Scanner;

/**
 * 问题描述：
 * 为了鼓励宝宝数数：
 * 买了n个玩具，从 1到n顺序排列，
 * 数数规则是：1 2...n,然后下一个是n-1号玩具，数为n+1
 * eg：3个玩具
 * 数数：		1 2 3 4 5 6 7 8 9 10 ... 
 * 玩具编号：	1 2 3 2 1 1 2 3 2 1	 ...
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
	 * 从1开始计算第m出现时实际数的数，
	 * 判断这个数是不是需要鼓掌,
	 * 需要鼓掌，则countTime次数+1
	 * 直到次数为k，返回x
	 * 
	 */
	private static int numInFact(int n, int m, int k) {
		int temp = 0;
		int infactNum = 0;
		while (temp != k) {
			
		}
		return infactNum;
	}
}
