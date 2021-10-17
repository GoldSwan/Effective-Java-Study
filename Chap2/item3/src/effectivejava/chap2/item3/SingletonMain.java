package effectivejava.chap2.item3;

import java.io.*;

import effectivejava.chap2.item3.enumsingleton.EnumSingleton;
import effectivejava.chap2.item3.fieldsingleton.FieldSingleton;
import effectivejava.chap2.item3.staticfatorysingleton.StaticFactorySingleton;

public class SingletonMain {

	public static class SerializationTester {
		public static Object deserialize(byte[] serializedData) {
			ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
			try (ObjectInputStream ois = new ObjectInputStream(bis)) {
				return ois.readObject();
			} catch (Exception e) {

			}
			return null;
		}
		
		public static byte[] serialize(Object instance) {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
				oos.writeObject(instance);
			} catch (Exception e) {

			}
			return bos.toByteArray();
		}		
	}
	
	public static void main(String[] args) {
		byte[] serializedData = null;
		FieldSingleton result1 = null;
		StaticFactorySingleton result2 = null;
		EnumSingleton result3 = null;
		//public static final 필드 방식의 싱글턴
		//직렬화가 구현되지 않은 싱글턴
		//역직렬화시 readObject 메서드가 호출되어 새로운 인스턴스가 생성되므로 싱글톤이 아니게 됨.
		FieldSingleton fieldSingleton = FieldSingleton.INSTANCE;	
		serializedData = SerializationTester.serialize(fieldSingleton);
		result1 = (FieldSingleton)SerializationTester.deserialize(serializedData);
		System.out.println("instance == result : " + (fieldSingleton == result1));
		System.out.println("instance.equals(result) : " + (fieldSingleton.equals(result1)));
		fieldSingleton.WorkStart();
		//정적 팩터리 방식의 싱글턴
		//직렬화가 구현된 싱글턴
		//역직렬화해도 readResolve 메소드를 선언해두면  readObject 메서드가 호출되도 이를 통해 만들어진 인스턴스는 가비지 컬렉션 대상이 되므로 싱글턴이 유지됨.
		StaticFactorySingleton staticFactorySingleton = StaticFactorySingleton.getInstance();
		serializedData = SerializationTester.serialize(staticFactorySingleton);
		result2 = (StaticFactorySingleton)SerializationTester.deserialize(serializedData);
		System.out.println("instance == result : " + (staticFactorySingleton == result2));
		System.out.println("instance.equals(result) : " + (staticFactorySingleton.equals(result2)));
		staticFactorySingleton.WorkStart();
		//열거 타입 방식의 싱글턴
		//직렬화해도 이를 위한 추가 로직을 구현할 필요가 없음.
		EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
		serializedData = SerializationTester.serialize(enumSingleton);
		result3 = (EnumSingleton)SerializationTester.deserialize(serializedData);
		System.out.println("instance == result : " + (enumSingleton == result3));
		System.out.println("instance.equals(result) : " + (enumSingleton.equals(result3)));		
		enumSingleton.WorkStart();
	}
}
