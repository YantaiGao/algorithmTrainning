package acmcoder;

import java.util.Scanner;

/**
 * ������صĵ�������
 * ������һ���ܹ��ﵽ����ĸ߶ȣ��Ժ�ÿ�ζ����ᳬ��ǰһ�εĸ߶ȣ�����������صĵ�������
 * eg:
 * 389 207 155 300 299 170 158 65
 * ����������� 389 300 299 170 158 65 ---> 6������
 * @author Administrator
 *
 */

public class No4_LanjieDaodan {

	public static void main(String[] args) {
		
		Scanner sin = new Scanner(System.in);
		
		//��������
		int groupNum = sin.nextInt();
		
		int res = 0;
		
		for (int i = 0; i < groupNum; i++) {
			
			//ÿ�������
			int caseNum = sin.nextInt();
			
			int[] caseArr = new int[caseNum];
			
			for (int j = 0; j < caseNum; j++) {
				caseArr[j] = sin.nextInt();
			}
			//��ÿ�����������
			res = mostLanJieDaoDan(caseArr);
			System.out.println(res);
		}
	}

	private static int mostLanJieDaoDan(int[] caseArr) {
		
		return 0;
	}

}
