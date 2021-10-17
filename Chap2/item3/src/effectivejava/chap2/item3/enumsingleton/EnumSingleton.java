package effectivejava.chap2.item3.enumsingleton;

public enum EnumSingleton {
	INSTANCE;
	public void WorkStart() {System.out.println("EnumSingleton 작업을 시작합니다.");}
}
