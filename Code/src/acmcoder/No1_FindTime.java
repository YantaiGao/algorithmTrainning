package acmcoder;

import java.util.Scanner;

/**
 * �ֻ�������������һ������
 * ��Ϣ�ǣ���һ����l��L����1����r��ʮ�������������Ķ�������m��1
 * ������Լ��β��ܽ⿪����
 * �����ڷ���-1
 * 
 * Input: 1 4 2.��ʾ1-4������������2��1 
 * Output��1��ֻ��3�Ķ�����������1
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
	 * ��ÿ�����֣��ж϶����Ʊ�ʾ���ж��ٸ�1
	 * �κ�һ������n�����Ա�ʾ�ɣ�
	 * n = 2^0 + 2^1 +2^k + ...
	 * ����˼·�ǲ��Եģ�
	 * eg:
	 * 2 = 2^1
	 * 4 = 2^2
	 * ���ǲ��ý�ʮ����ת��Ϊ2���Ƶķ���
	 * @param l
	 * @param r
	 * @param m
	 * @return
	 */
	private int countTime(int l, int r, int m) {
		int res = 0;
		//��L��R�����ж�
		for (int i = l; i <= r; i++) {
			int temp = i,k = 0;
			//��2ֱ��0
			while (temp != 0) {
				//�ж������Ƿ�Ϊ1
				if (temp%2 == 1) {
					k++;
				}
				temp = temp / 2;
			}
			//�ж��Ƿ��������
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
