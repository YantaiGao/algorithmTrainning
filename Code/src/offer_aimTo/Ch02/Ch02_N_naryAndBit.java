package offer_aimTo.Ch02;

public class Ch02_N_naryAndBit {
	
	/**
	 * 进制n-nary和位运算相关
	 * (1)excel中列是这样定义的：A B C ... AB AC
	 * 	定义一个函数，输入字母表示的列号编码，返回是第多少列
	 * 	实际上这就是一个26进制的转化问题
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ch02_N_naryAndBit nAndB = new Ch02_N_naryAndBit();
		
		//No1:Excel问题
		String  str0 = "EF";
		int res0 = 0;
		res0 = nAndB.findColumnNum(str0);
		System.out.println(str0 + "是excel中第" + res0 + "列。");
		
	}

	private int findColumnNum(String str0) {
		if (str0.length() <= 0 || str0 == null) {
			return -1;
		}else {
			int res = 0;
			return res;
		}
	}

}
