package acmcoder;
/**
 * 手机被锁：密码是一个数字
 * 信息是：是一个从l（L不是1）到r的十进制整数，它的二进制有m个1
 * 求：最多试几次才能解开密码
 * 不存在返回-1
 * 
 * Input: 1 4 2.表示1-4，有2个1 
 * Output：1
 * @author lenovo
 *
 */
public class No1_FindTime {

	public static void main(String[] args) {
		int l,r,m;
		int res;
		
		l = 1;
		r = 4;
		m = 2;
		
		No1_FindTime find = new No1_FindTime();
		
		res = find.countTime(l,r,m);
		
		System.out.println(res);
		
	}
	/**
	 * 对每个数字，判断二进制表示中有多少个1
	 * 任何一个整数n都可以表示成：
	 * n = 2^0 + 2^1 +2^k + ...
	 * @param l
	 * @param r
	 * @param m
	 * @return
	 */
	private int countTime(int l, int r, int m) {
		int res = 0;
		for (int i = l; i <= r; i++) {
			int temp = 0,k = 0;
			while (temp != i) {
				temp = (temp + ((int)Math.pow(2, k)));
				k++;
			}
			if (m == k) {
				res++;
			}
		}
		return res;
	}

}
