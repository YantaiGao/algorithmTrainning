package acmcoder;

import java.util.Scanner;

/**
 * �ֻ�������������һ������
 * ��Ϣ�ǣ���һ����l��L����1����r��ʮ�������������Ķ�������m��1
 * ������Լ��β��ܽ⿪����
 * �����ڷ���-1
 * 
 * Input: 1 4 2.��ʾ1-4����2��1 
 * Output��1
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
