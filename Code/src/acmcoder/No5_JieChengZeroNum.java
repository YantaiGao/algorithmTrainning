package acmcoder;

public class No5_JieChengZeroNum {

	/**
	 * 求一个数的阶乘的结果中有多少个0
	 * 思路：
	 * 一个数，阶乘中有多少0，关键看2和5的个数，显然2的个数明显大于5的个数，因此只需要考虑5的个数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int num = 10;
		int res = countZeroNum(num);
		System.out.println(res);

	}

	/**
	 * 实际计算中，首先减去余数，然后除以5，
	 * 是5的倍数的数有： 1024 / 5 = 204个
	 * 是25的倍数的数有：1024 / 25 = 40个
	 * 是125的倍数的数有：1024 / 125 = 8个
	 * 是625的倍数的数有：1024 / 625 = 1个
	 * @param num
	 * @return
	 */
	
	private static int countZeroNum(int num) {
		int res = 0;
		
		while (num>5) {
			
//			num = (num-(num%5))/5;
			num = num /5;
			res = res+num;
			
		}
		
		return res;
	}

}
