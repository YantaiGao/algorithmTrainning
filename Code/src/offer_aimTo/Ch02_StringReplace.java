package offer_aimTo;
/**
 * 
 * @author gyt
 * 2016-08-14
 * 
 * 需求：
 * 将字符串中空格换为%20
 * 网络编程中，若url中含有空格‘#’等特殊符号，服务器无法获取正确的参数值。需要转为服务器识别的字符。
 * 规则是在‘%’后跟上ASCII码的两位16进制表示。空格的ASCII码是32,16进制为0x20.
 *
 */
public class Ch02_StringReplace {

	public static void main(String[] args) {
		//方法一：使用String的replaceAll功能，查看源码发现，在String中java使用正则表达式，实现的这个功能
		String str = "Hello world,I am gyt.";//正常用例
		str = "  ";//全空格
		str = "Gyt";//无空格
		str = " ";//一个空格
		String str2 = str.replaceAll(" ", "%20");
		System.out.println("str = " + str + "\n" + "str2 = " + str2);
		
		/**
		 * 方法二：自己实现
		 * 首先找到所有空格的个数，
		 * 然后从后向前移动，并在应该插入的位置插入
		 */
		String res = null; 
		res = replaceAllSpace(str);
		System.out.println("res　=　" + res);
		
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
			
			//每一次替换：%20都比原来‘ ’多了2个
			int newLen = oriCharArr.length + 2*spaceNum;
			newCharArr = new char[newLen];
			
			//注意：
			//需要使用newlen--来记录位置，
			//从后向前，遍历旧的数组，将每个字符写到新字符数组的尾部，
			//每写完一个，指针前移，
			//遇到空格，替换，并前移三个
			int len = newLen - 1;//数组从0开始
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
