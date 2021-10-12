package effectivejava.chap2.item3.fieldsingleton;

public class FieldSingleton {
	public static final FieldSingleton INSTANCE = new FieldSingleton();
	private FieldSingleton() {}
	public void WorkStart() {System.out.println("FieldSingleton 작업을 시작합니다.");}
}