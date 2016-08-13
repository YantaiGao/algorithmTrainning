package offer_aimTo;

public class Ch02_Singleton {
	/**
	 * ����ģʽ������ʵ��
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	/**
	 * ������ʵ�ַ�ʽһ��
	 * ����ʽ
	 * ȱ�㣺�̲߳���ȫ
	 */
	private static Ch02_Singleton singleton;
	//˽�л����캯��
	private Ch02_Singleton(){
		
	}
	public static Ch02_Singleton getInstance() {
		if (singleton == null) {
			return new Ch02_Singleton();
		}
		return singleton;
	}
	
}

/**
 * ����ʽ���̰߳�ȫ������
 * ʹ��synchronized ����Ч�ʲ��Ǻܸ�
 */

class Singleton_safe{
	//˽�й��캯��
	private Singleton_safe(){
		
	}
	//ʵ��
	private static Singleton_safe instance_safe;
	//�̰߳�ȫ�Ļ�ȡ����
	public static synchronized Singleton_safe getInstanceSafe() {
		if (instance_safe == null) {
			instance_safe = new Singleton_safe();
		}
		return instance_safe;
	}
}

/**
 * ����ʽ���̰߳�ȫ�ĵ�����
 * ��Ч
 */

class Singleton_safe_eff{
	private Singleton_safe_eff(){
		
	}
	private static Singleton_safe_eff instance_Safe_eff;
	
	public static Singleton_safe_eff getInstanceSafeEff() {
		if (instance_Safe_eff == null) {
			synchronized (Singleton_safe_eff.class) {
				instance_Safe_eff = new Singleton_safe_eff();
			}
		}
		return instance_Safe_eff;
	}
}

/**
 * ����ʽ������
 * û���̰߳�ȫ���⣬�����Ƿ���ö���һ��ʵ�����ڴ���
 */

class SingleTon{
	//˽�й��캯��
	private SingleTon() {
	
	}
	//Ψһʵ������ǰʵ����
	private static SingleTon instance = new SingleTon();
	//�����ṩΨһʵ��
	public SingleTon getInstance(){
		return instance;
	}
}

