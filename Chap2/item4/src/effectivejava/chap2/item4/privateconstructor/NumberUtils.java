package effectivejava.chap2.item4.privateconstructor;
//Number와 관련된 함수를 모아놓은 유틸 클래스
public class NumberUtils {
	//인스턴스 생성 방지용 private 생성자 
	//AssertionError을 throw하여 클래스 안에서 실수로라도 생성자를 호출하지 않도록 방지
	private NumberUtils() {throw new AssertionError();}
	public static boolean isOdd(int num) {
		return num % 2 == 0 ? false : true;
	}
	public static boolean isEven(int num) {
		return num % 2 == 0 ? true : false;
	}
}
