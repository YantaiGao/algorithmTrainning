package Ds.huiWenShu;
/**
 * 2016-09-01
 * ��������
 * 121��12321��������
 * ��1������һ�����ж��ǲ��ǻ�����
 * @author Administrator
 *
 */
public class HuiWenShu {

	public static void main(String[] args) {
		HuiWenShu huiWenShu = new HuiWenShu();
		//����һ�������ж��ǲ��ǻ�����
		int a = 12321;
		boolean flag = false;
		flag =huiWenShu.judgeHuiwenShu(a);
		if (flag) {
			System.out.println(a + "\t �ǻ�����");
		}else {
			System.out.println(a + "\t ���ǻ�����");
		}
	}
	/**
	 * ����һ������һ�����ж��ǲ��ǻ�����
	 * @param a
	 * @return
	 */
	private boolean judgeHuiwenShu(int a) {
		
		String str = String.valueOf(a);
		StringBuffer sb = new StringBuffer(str);
		//���Ӵ�Сд����
		boolean flag = sb.reverse().toString().equalsIgnoreCase(str); 
		return flag;
	}

}
