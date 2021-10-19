package effectivejava.chap2.item4;

import effectivejava.chap2.item4.privateconstructor.NumberUtils;

public class Main {

	public static void main(String[] args) {
		//NumberUtils numberUtils = new NumberUtils(); //private 생성자에 의해 인스턴스 생성 불가능하므로 컴파일 에러가 남
		int num = 123456789;
		System.out.println(NumberUtils.isOdd(num));
		System.out.println(NumberUtils.isEven(num));
	}

}
