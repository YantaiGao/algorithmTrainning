package Ds.gcd;

public class GcdOfAB {

	public static void main(String[] args) {
		int a = 4;
		int b = 4000100;
		int res = gcd(a, b);
		System.out.println("a = " + a + "\t" +"b = "+ b +"\t--- " + res);
		
		int res2 = fastGCD(a, b);
		System.out.println(res2);
	}
	

	public static int gcd(int a,int b){
		int t;
		if(a<b){
			t=b;
			b=a;
			a=t;
		}
		while(b!=0){
			t=b;
			b=a % b;
			a=t;
		}
		return a;
	}
	
	
	public static int fastGCD(int a,int b) {
		while (a*b != 0) {
			if (a < b) {
				b%=a;
			}else {
				a%=b;
			}
		}
		return a+b;
	}
	
}
