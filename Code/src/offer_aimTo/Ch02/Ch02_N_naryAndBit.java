package offer_aimTo.Ch02;

public class Ch02_N_naryAndBit {
	
	/**
	 * ����n-nary��λ�������
	 * (1)excel��������������ģ�A B C ... AB AC
	 * 	����һ��������������ĸ��ʾ���кű��룬�����ǵڶ�����
	 * 	ʵ���������һ��26���Ƶ�ת������
	 * @param args
	 */
	public static void main(String[] args) {
		
		Ch02_N_naryAndBit nAndB = new Ch02_N_naryAndBit();
		
		//No1:Excel����
		String  str0 = "EF";
		int res0 = 0;
		res0 = nAndB.findColumnNum(str0);
		System.out.println(str0 + "��excel�е�" + res0 + "�С�");
		
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
