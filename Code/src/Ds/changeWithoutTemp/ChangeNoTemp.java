package Ds.changeWithoutTemp;

/**
 * 
 * @author Administrator
 *
 *	��������������ͨ����ʹ��temp:
 *  ��ʹ���м�����ķ���:
 *  (1)ʹ�üӼ���
 *  	������������������һ�𣬺ͷŵ���һ�����ϣ�
 *  	ʹ�úͼ��ڶ����������ʱ�ڶ���������ԭ����һ��������һ�������Ǻ�
 *  	ʹ�ú��ټ��µĵڶ���������һ�����ͱ��ԭ���ڶ�����
 *  (2)ʹ�����
 *  	//�����������ԣ�
 *  	һ�������������0��
 *  	һ�������0����ڱ���
 */

public class ChangeNoTemp {

	public static void main(String[] args) {
		int a = 9;
		int b = 10;
		System.out.println("a = " + a + "\t" + "b = " + b);
		//temp
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println("a = " + a + "\t" + "b = " + b);
		
		a = 9;
		b = 10;
		System.out.println("a = " + a + "\t" + "b = " + b);
		//�Ӽ���
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a + "\t" + "b = " + b);
		
		a = 9;
		b = 10;
		System.out.println("a = " + a + "\t" + "b = " + b);
		//���
		b = a ^ b;	//��������ʱ����
		a = a ^ b;
		b = a ^ b;
		System.out.println("a = " + a + "\t" + "b = " + b);
	}

}
