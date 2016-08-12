package offer_aimTo;

public class Ch02_Singleton {
	/**
	 * 单例模式，几种实现
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	/**
	 * 单例类实现方式一：
	 * 懒汉式
	 * 缺点：线程不安全
	 */
	private static Ch02_Singleton singleton;
	//私有化构造函数
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
 * 懒汉式：线程安全单例类
 * 使用synchronized 但是效率不是很高
 */

class Singleton_safe{
	//私有构造函数
	private Singleton_safe(){
		
	}
	//实例
	private static Singleton_safe instance_safe;
	//线程安全的获取方法
	public static synchronized Singleton_safe getInstanceSafe() {
		if (instance_safe == null) {
			instance_safe = new Singleton_safe();
		}
		return instance_safe;
	}
}

/**
 * 懒汉式：线程安全的单例类
 * 高效
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
 * 饿汉式单例类
 * 没有线程安全问题，无论是否调用都有一个实例在内存中
 */

class SingleTon{
	//私有构造函数
	private SingleTon() {
	
	}
	//唯一实例，提前实例化
	private static SingleTon instance = new SingleTon();
	//对外提供唯一实例
	public SingleTon getInstance(){
		return instance;
	}
}

