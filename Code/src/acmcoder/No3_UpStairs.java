package acmcoder;

import java.util.Scanner;

public class No3_UpStairs {
	/**
	 * һ��¥�ݹ�m��̨�ף�ÿ������һ����������̨�ף�Ҫ��m��̨�ף�һ���ж������߷�
	 * 
	 * Input��
	 * x����
	 * m1̨����
	 * m2
	 * ...
	 * mx
	 * 
	 * Output:
	 * ÿ������Ӧ�����
	 * 
	 * ��ͨ���˼·��
	 * һ��m��̨�ף���һ����̨�׵�ֻ������ѡ����һ��̨�ף����ܴ���������[ʣ��n-1]��̨�׵ĸ���,
	 * ������̨�ף�������������[ʣ��n-2��̨��]�ĸ���,
	 * ֻ��������ѡ������m��̨�׵��ܷ�������
	 * ��f(n) = f(n-1) + f(n-2)
	 * 
	 * ���ڵ����⣺��̨�����ﵽ46��������50 ��ʱ���㷨����Խ��Խ��
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int groupNum,m,res;
		Scanner sc = new Scanner(System.in);
		groupNum = sc.nextInt();
		No3_UpStairs upStairs = new No3_UpStairs();
		for (int i = 0; i < groupNum; i++) {
			m = sc.nextInt();
			res = upStairs.computeMethodsNum(m);
			System.out.println(res);
		}
	}

	/**
	 * ע��Ҫ��m == 0 �� m == 3
	 * @param m
	 * @return
	 */
	private int computeMethodsNum(int m) {
		if (m == 1 || m == 0) {
			return 0;
		}else if (m == 2) {
			return 1;
		}else if (m  == 3) {
			return 2;
		}else {
			return computeMethodsNum(m-1) + computeMethodsNum(m-2);
		}
	}

}
