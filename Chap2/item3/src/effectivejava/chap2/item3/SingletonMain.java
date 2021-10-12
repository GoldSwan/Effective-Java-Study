package effectivejava.chap2.item3;

import effectivejava.chap2.item3.fieldsingleton.FieldSingleton;
import effectivejava.chap2.item3.staticfatorysingleton.StaticFactorySingleton;

public class SingletonMain {

	public static void main(String[] args) {
		FieldSingleton fieldSingleton = FieldSingleton.INSTANCE;
		fieldSingleton.WorkStart();
		
		StaticFactorySingleton staticFactorySingleton = StaticFactorySingleton.getInstance();
		staticFactorySingleton.WorkStart();
	}

}
