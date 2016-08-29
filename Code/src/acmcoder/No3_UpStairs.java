package acmcoder;

import java.util.Scanner;

public class No3_UpStairs {
	/**
	 * 一个楼梯共m个台阶，每次能上一个或者两个台阶，要走m个台阶，一共有多少种走法
	 * 
	 * Input：
	 * x组数
	 * m1台阶数
	 * m2
	 * ...
	 * mx
	 * 
	 * Output:
	 * 每组数对应的输出
	 * 
	 * 普通解决思路：
	 * 一共m个台阶，第一次上台阶的只有两种选择，上一个台阶，则总次数就是上[剩下n-1]个台阶的个数,
	 * 上两个台阶，则总数就是上[剩下n-2个台阶]的个数,
	 * 只有这两种选择，则上m个台阶的总方法数，
	 * 即f(n) = f(n-1) + f(n-2)
	 * 
	 * 存在的问题：当台阶数达到46以上甚至50 的时候，算法将会越来越慢
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int groupNum,m,res;
		Scanner sc = new Scanner(System.in);
		groupNum = sc.nextInt();
		No3_UpStairs upStairs = new No3_UpStairs();
		for (int i = 0; i < groupNum; i++) {
			m = sc.nextInt();
			res = upStairs.computeMethodsNum(m);
			System.out.println(res);
		}
	}

	/**
	 * 注意要有m == 0 和 m == 3
	 * @param m
	 * @return
	 */
	private int computeMethodsNum(int m) {
		if (m == 1 || m == 0) {
			return 0;
		}else if (m == 2) {
			return 1;
		}else if (m  == 3) {
			return 2;
		}else {
			return computeMethodsNum(m-1) + computeMethodsNum(m-2);
		}
	}

}
