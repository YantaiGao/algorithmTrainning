package Ds.changeWithoutTemp;

/**
 * 
 * @author Administrator
 *
 *	交换两个数，普通方法使用temp:
 *  不使用中间变量的方法:
 *  (1)使用加减法
 *  	将两个数加起来放在一起，和放到第一个数上，
 *  	使用和减第二个数，则此时第二个数就是原来第一个数，第一个数还是和
 *  	使用和再减新的第二个数，第一个数就变成原来第二个数
 *  (2)使用异或
 *  	//异或的两个特性：
 *  	一个数异或本身恒等于0；
 *  	一个数异或0恒等于本身。
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
		//加减法
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a = " + a + "\t" + "b = " + b);
		
		a = 9;
		b = 10;
		System.out.println("a = " + a + "\t" + "b = " + b);
		//异或
		b = a ^ b;	//被当做临时变量
		a = a ^ b;
		b = a ^ b;
		System.out.println("a = " + a + "\t" + "b = " + b);
	}

}
