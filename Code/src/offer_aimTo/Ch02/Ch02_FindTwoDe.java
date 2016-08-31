package offer_aimTo.Ch02;
/**
 * 
 * @author gyt
 * 
 * ��ά���������������������򣬲��Ҹ���ֵ�Ƿ�������
 * 
 * ���磺
 *  1 2 8 9 
 *  2 4 9 12 
 *  4 7 10 13
 *  6 8 11 15
 *  
 *  ˼·��
 *  ��7Ϊ��
 *  ���ȼ�����Ͻǣ�9������7������һ�ж�������
 *  Ȼ�����ƣ�8������7������Ҳû��
 *  ����2��С��7�����ƣ�4������7
 *  
 *  ��Ϊ6 �Ƶ�7֮�����ƣ�4�������ƣ�6
 *  ��Ϊ5���ҵ�6֮������������Ҳ���
 *  
 *  �����Դ����½ǳ��������ǲ��ܴ����������ǳ���
 *  
 *  ���ޣ�ֻ�ܴ�����
 *
 */
public class Ch02_FindTwoDe {
	
	public static void main(String[] args) {
		//the num to find
		int x = 9;
		int[][] twoDeArr  = {
			{1,2,8,9},	
			{2,4,9,12},
			{4,7,10,13},
			{6,8,11,15}
		};
		
		String resLoc;
		
		resLoc = findLoc(twoDeArr,x);
		
		System.out.println(resLoc);
	}

	private static String findLoc(int[][] twoDeArr, int x) {
		
		int i = 0,j = twoDeArr.length-1;
		
		while (i < twoDeArr.length && j >= 0) {
			if (twoDeArr[i][j] < x) {
				i++;
				continue;
			}else if (twoDeArr[i][j] > x) {
				j--;
				continue;
			}else {
				return i+ " \t" + j;
			}			
		};
		
		return "Cant Find.";
	}

}
