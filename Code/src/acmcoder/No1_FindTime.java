package acmcoder;

import java.util.Scanner;

/**
 * 手机被锁：密码是一个数字
 * 信息是：是一个从l（L不是1）到r的十进制整数，它的二进制有m个1
 * 求：最多试几次才能解开密码
 * 不存在返回-1
 * 
 * Input: 1 4 2.表示1-4，二进制中有2个1 
 * Output：1。只有3的二进制有两个1
 * @author lenovo
 *
 */
public class No1_FindTime {

	public static void main(String[] args) {
		int l=0,r=0,m=0;
		int res=0;
		
		Scanner scanner = new Scanner(System.in);
		
		if (scanner.hasNext()) {
			l = scanner.nextInt();
			r = scanner.nextInt();
			m = scanner.nextInt();
		}
		
		No1_FindTime find = new No1_FindTime();
		
		res = find.countTime(l,r,m);
		
		System.out.println(res);
		
	}
	/**
	 * 对每个数字，判断二进制表示中有多少个1
	 * 任何一个整数n都可以表示成：
	 * n = 2^0 + 2^1 +2^k + ...
	 * 这种思路是不对的：
	 * eg:
	 * 2 = 2^1
	 * 4 = 2^2
	 * 还是采用将十进制转化为2进制的方法
	 * @param l
	 * @param r
	 * @param m
	 * @return
	 */
	private int countTime(int l, int r, int m) {
		int res = 0;
		//从L到R依次判断
		for (int i = l; i <= r; i++) {
			int temp = i,k = 0;
			//除2直到0
			while (temp != 0) {
				//判断余数是否为1
				if (temp%2 == 1) {
					k++;
				}
				temp = temp / 2;
			}
			//判断是否符合条件
			if (m == k) {
				res++;
			}
		}
		if (res == 0) {
			return -1;
		}else {
			return res;
		}
	}
}
