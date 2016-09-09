package Ds.halfNumOfArr;

/**
 * �������г��ִ�������һ���Ԫ�أ����򷵻ظ�����û���򷵻�-1
 * ˼·��
 * һ��
 * 	�������������������ڴ�������һ���Ԫ�أ������м�λ�õ���һ�����������
 *  ��������ǰ����������һ�����ڳ��ִ�������һ���Ԫ��
 *  �����ʱ�临�Ӷ��ǣ�O(n*logn) 
 *  
 * ����
 * 	���������֪�����ִ�������һ���Ԫ�صĳ��ִ���������������Ԫ�صĳ��ִ����ĺͻ�Ҫ�ࡣ
 *  ��ʹ�������㷨��
 *  	����������飬��¼����ֵ��һ���������е�Ԫ�ص�ֵvalue��һ���Ǵ���count��
 *  	����һ��Ԫ���뵱ǰ�����Ԫ����ͬ���� count+1������count-1;
 *  	����count��ֵ����0����value��ֵ����Ϊ��ֵ������count=1
 *  	�����������ڴ������ֳ���һ���Ԫ�أ���count��ֵһ������0��value�б����ֵ��������Ҫ�ҵ�Ԫ�ء�
 *  	�ر�ע�⣺����ܸ���count�ǲ��ǵ��ڼ����жϣ����ֻ�ܸ������ĵ���ֵȥ��������֤�������ĳ��ִ�������һ�룬��Ҫ����һ������
 *  	ʱ�临�Ӷȣ�O(n);�ռ临�Ӷ�O(1)
 *  
 * @author Administrator
 *
 */
public class HalfNumOfArr {

	public static void main(String[] args) {
		
		int[] arr = {3,1,2,3,4,5,3,2,3,2,3,4,3,3,1,3,3};
		
		int[] arr1 = {1,2,3};//����һ��bug����������ֱ��ʹ��count!=0���жϣ����ܾͻ����
		
//		int res = findHalfNumOfArr(arr);
	
		int res = findHalfNumOfArr(arr1);
		
		if (res==-1) {
			System.out.println("�����ڳ��ִ�������һ���Ԫ�ء�");
		}else {
			System.out.println("���ִ�������һ���Ԫ��Ϊ��" + "\t" + res);
		}
		
		
		
	}

	private static int findHalfNumOfArr(int[] arr) {
		int value=arr[0];
		int count = 1;
		//��������
		for (int i = 1; i < arr.length; i++) {
			//����Ϊ0�������µ����ݺͳ���
			if (count==0) {
				value = arr[i];
				count = 1;
			}else if (arr[i] == value) {
				count++;
			}else {
				count--;
			}
		}
		//�����ж��ǲ��Եģ���3��Ԫ�ص�ʱ��count������Ϊ1
//		if (count != 0) {
//			return value;
//		}else {
//			return -1;
//		}
		
		if(IsMoreThanHalf(arr,value)){
			return value;
		}else {
			return -1;
		}
	}

	
	/**
	 * ����ʹ��������ж��ǲ��ǳ���һ��
	 */
	private static boolean IsMoreThanHalf(int[] arr, int value) {
		int len =  arr.length;
		int time = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				time++;
			}
		}
		if (2 * time <= len) {
			return false;
		}else {
			return true;
		}
	}
}
