package offer_aimTo;

/**
 * 求：斐波那契数列第n项,或者打印前n项
 * 相关题目
 * (1) 青蛙上台阶
 * (2) 矩形方块覆盖问题：
 * 	有一个宽为1，高为2的两1*1方框构成的矩阵，以此为图案，覆盖一个2*8的矩阵
 *  经过一次覆盖，可以推为f(8)=f(7)+f(6)
 *  详见矩形覆盖.doc
 * 公式：
 * f(0)=0;
 * f(1)=1;
 * f(n)=f(n-1)+f(n-2)
 * 
 * 普通思路：递归，从上到下
 * 但是：这种递归方式会有很多重复计算
 * eg:
 * f(10) = f(9)+f(8)
 * f(9) = f(8)+f(7)
 * f(8) = f(7)+f(6)
 * 
 * 优化思路：
 * 避免重复计算，从下到上计算
 * 
 * @author lenovo
 *
 */
public class Ch02_Fibonacci {

	public static void main(String[] args) {
		int n = 50;
		int res;
		Ch02_Fibonacci fibo = new Ch02_Fibonacci();
//		for (int i = 0; i <= n; i++) {
//			res = fibo.findN(i);
//			System.out.print(res+"\t");	
//			if (i%10 == 0 && i!=0) {
//				System.out.println();
//			}
//		}
		
		long res2 = 0;
		for (int i = 0; i <= n; i++) {
			res2 = fibo.findNFromDown(i);
			System.out.print(res2 + "\t");
			if (i%10 == 0 && i!=0) {
				System.out.println();
			}
		}
	}

	/**
	 * 传统的递归，由上到下递归
	 * 易理解，但是低效，重复计算多
	 * @param n
	 * @return
	 */
	private int findN(int n) {
		if (n==0) {
			return 0;
		}else if(n==1){
			return 1;
		}else {
			return findN(n-1)+findN(n-2);
		}
	}

	/**
	 * 优化1：
	 * 避免从上到下的重复计算，从下到上计算
	 * 时间复杂度o(n)
	 * @param n
	 * @return
	 */
	private long findNFromDown(int n) {
		if (n==0) {
			return 0;
		}else if(n==1){
			return 1;
		}else {
			
			long fibo1 = 1;
			long fibo2 = 0;
			
			long fiboN = 0;
			
			for (int i = 0; i < n; i++) {
				fiboN = fibo1 + fibo2;
				fibo2 = fibo1;
				fibo1 = fiboN;
			}
			
			return fiboN;
		}
		
	}
}
