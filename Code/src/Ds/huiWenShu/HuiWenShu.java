package Ds.huiWenShu;
/**
 * 2016-09-01
 * 回文数：
 * 121，12321，这种数
 * （1）给定一个数判断是不是回文数
 * @author Administrator
 *
 */
public class HuiWenShu {

	public static void main(String[] args) {
		HuiWenShu huiWenShu = new HuiWenShu();
		//给定一个数，判断是不是回文数
		int a = 12321;
		boolean flag = false;
		flag =huiWenShu.judgeHuiwenShu(a);
		if (flag) {
			System.out.println(a + "\t 是回文数");
		}else {
			System.out.println(a + "\t 不是回文数");
		}
	}
	/**
	 * 方法一：给定一个数判断是不是回文数
	 * @param a
	 * @return
	 */
	private boolean judgeHuiwenShu(int a) {
		
		String str = String.valueOf(a);
		StringBuffer sb = new StringBuffer(str);
		//无视大小写区别
		boolean flag = sb.reverse().toString().equalsIgnoreCase(str); 
		return flag;
	}

}
