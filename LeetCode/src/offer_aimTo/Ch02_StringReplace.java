package offer_aimTo;
/**
 * 
 * @author gyt
 * 2016-08-14
 * 
 * ����
 * ���ַ����пո�Ϊ%20
 * �������У���url�к��пո�#����������ţ��������޷���ȡ��ȷ�Ĳ���ֵ����ҪתΪ������ʶ����ַ���
 * �������ڡ�%�������ASCII�����λ16���Ʊ�ʾ���ո��ASCII����32,16����Ϊ0x20.
 *
 */
public class Ch02_StringReplace {

	public static void main(String[] args) {
		//����һ��ʹ��String��replaceAll���ܣ��鿴Դ�뷢�֣���String��javaʹ��������ʽ��ʵ�ֵ��������
		String str = "Hello world,I am gyt.";//��������
		str = "  ";//ȫ�ո�
		str = "Gyt";//�޿ո�
		str = " ";//һ���ո�
		String str2 = str.replaceAll(" ", "%20");
		System.out.println("str = " + str + "\n" + "str2 = " + str2);
		
		/**
		 * ���������Լ�ʵ��
		 * �����ҵ����пո�ĸ�����
		 * Ȼ��Ӻ���ǰ�ƶ�������Ӧ�ò����λ�ò���
		 */
		String res = null; 
		res = replaceAllSpace(str);
		System.out.println("res��=��" + res);
		
	}

	private static String replaceAllSpace(String str) {
		StringBuilder sb = new StringBuilder();
		if (str == null) {
			return "NULL";
		}else {
			int spaceNum = 0;
			char[] newCharArr;
			char[] oriCharArr = str.toCharArray();
			for (int i = 0; i < oriCharArr.length; i++) {
				if (oriCharArr[i] == ' ') {
					spaceNum++;
				}
			}
			
			//ÿһ���滻��%20����ԭ���� ������2��
			int newLen = oriCharArr.length + 2*spaceNum;
			newCharArr = new char[newLen];
			
			//ע�⣺
			//��Ҫʹ��newlen--����¼λ�ã�
			//�Ӻ���ǰ�������ɵ����飬��ÿ���ַ�д�����ַ������β����
			//ÿд��һ����ָ��ǰ�ƣ�
			//�����ո��滻����ǰ������
			int len = newLen - 1;//�����0��ʼ
			for (int i = oriCharArr.length-1; i >= 0; i--) {
				if (oriCharArr[i] != ' ') {
					newCharArr[len] = oriCharArr[i];
					len--;
				}else {
					newCharArr[len--] = '0';
					newCharArr[len--] = '2';
					newCharArr[len--] = '%';
				}
			}
			
			for (char c : newCharArr) {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
