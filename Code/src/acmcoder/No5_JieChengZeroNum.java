package acmcoder;

public class No5_JieChengZeroNum {

	/**
	 * ��һ�����Ľ׳˵Ľ�����ж��ٸ�0
	 * ˼·��
	 * һ�������׳����ж���0���ؼ���2��5�ĸ�������Ȼ2�ĸ������Դ���5�ĸ��������ֻ��Ҫ����5�ĸ���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int num = 10;
		int res = countZeroNum(num);
		System.out.println(res);

	}

	/**
	 * ʵ�ʼ����У����ȼ�ȥ������Ȼ�����5��
	 * ��5�ı��������У� 1024 / 5 = 204��
	 * ��25�ı��������У�1024 / 25 = 40��
	 * ��125�ı��������У�1024 / 125 = 8��
	 * ��625�ı��������У�1024 / 625 = 1��
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
