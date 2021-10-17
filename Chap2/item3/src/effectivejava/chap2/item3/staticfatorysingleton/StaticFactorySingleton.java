package effectivejava.chap2.item3.staticfatorysingleton;

import java.io.Serializable;

public class StaticFactorySingleton implements Serializable{
	private static final StaticFactorySingleton INSTANCE = new StaticFactorySingleton();
	private StaticFactorySingleton () {}
	public static StaticFactorySingleton getInstance() {return INSTANCE;}
	public void WorkStart() {System.out.println("StaticFactorySingleton 작업을 시작합니다.");}
	private Object readResolve() {return INSTANCE;}//직렬화시 가짜 싱글턴 탄생 방지
}
