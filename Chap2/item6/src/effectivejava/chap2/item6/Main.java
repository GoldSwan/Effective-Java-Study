package effectivejava.chap2.item6;

public class Main {

	public static void main(String[] args) {
		
		String[][] strStudentInfoArray = {{"alice","22"},{"sam","23"},{"swan","24"},{"bob","25"}};//학생의 이름, 나이 정보를 담은 배열
		//불필요한 객체를 생성하는 예
		String str = "";
		for(String[] strStudentInfo : strStudentInfoArray){
			//String 객체 반복 생성 - new String으로 초기화할 경우 String 객체를 새로 만들게 된다.
			String strName = new String(strStudentInfo[0]);
			//System.identityHashCode : 객체의 고유한 hashcode를 리턴, 객체가 서로 같다면 같은 값, 다르다면 다른 값
			if(System.identityHashCode(strName) == System.identityHashCode(strStudentInfo[0])){
				System.out.println("strName == strStudentInfo[0] true");
			}
			else {
				System.out.println("strName == strStudentInfo[0] false");
			}

			String strAge = new String(strStudentInfo[1]);
			if(Integer.parseInt(strAge)>22) {
				//+연산이 일어날 때 마다 String객체가 반복적으로 생성됨 StringBuilder 이용 필요
				str += "[" + strName + "," + strAge + "]";
				System.out.println(System.identityHashCode(str));//계속 달라짐
			}
		}
		System.out.println(str);
		//불필요한 객체 생성 코드 개선
		StringBuilder sb = new StringBuilder();
		for(String[] strStudentInfo : strStudentInfoArray){
			//new String을 사용하지 않을 경우 Java Heap Memory의 String constant pool에서 같은 값이 있는 경우 그 주소를 리턴하므로 객체가 새로 생성되지 않음
			String strName = strStudentInfo[0];
			if(System.identityHashCode(strName) == System.identityHashCode(strStudentInfo[0])){
				System.out.println("strName == strStudentInfo[0] true");
			}
			else {
				System.out.println("strName == strStudentInfo[0] false");
			}
			String strAge = strStudentInfo[1];
			if(Integer.parseInt(strAge)>22) {
				//StringBuilder 이용하여 String 객체가 연속적으로 생성되는걸 방지
				//sb.setLength(0);//setLength 초기화방법이 제일 빠르다는 블로그 실험글 참조하여 StringBuilder를 초기화할 일이 있으면 setLength로 초기화
				//sb.delete(0, sb.length());//StringBuilder의 다른 초기화 방법 성능은 setLength와 비슷함
				sb.append("[").append(strName).append(",").append(strAge).append("]");		
			}
		}
		str = sb.toString();// String객체를 한번만 생성
		System.out.println(str);
		
		//생성자를 통한 객체 생성 - 불필요한 객체를 생성할 수 있음
		Integer num1 = new Integer(10);
		Integer num2 = new Integer(10);
		//정적 팩터리 매서드를 통한 객체 생성 - 불필요한 객체 생성 방지 가능
		Integer num3 = Integer.valueOf(10);
		Integer num4 = Integer.valueOf(10);
		Boolean b1 = new Boolean("true");
		Boolean b2 = new Boolean("true");
		Boolean b3 = Boolean.valueOf("true");
		Boolean b4 = Boolean.valueOf("true");
		String s1 = new String("str"); 
		String s2 = new String("str"); 

		//Integer생성자를 통해 객체를 생성하므로 num1 와 num2는 서로 다른 객체이므로 출력되지 않음
		if(num1 == num2) {
			System.out.println("num1 == num2 true");
		}
		else {
			System.out.println("num1 == num2 false");
		}
		//Integer.valueOf 정적 팩터리 메서드를 사용했으므로 서로 같은 객체! 따라서 출력됨
		if(num3 == num4) {
			System.out.println("num3 == num4 true");
		}
		else {
			System.out.println("num3 == num4 false");
		}
		//책 예제대로면 Boolean생성자를 통해 객체를 새로 생성하여 서로 다른 객체이므로 false여야 하는데 true 출력됨. 확인 필요
		//해결 : b1,b2를 Boolean 이 아니라 boolean 로 초기화해서 그랬던거였음.boolean은 primitive type으로 초기화되므로 객체 비교가 아니라 실제값을 비교하므로 true를 반환하는 거였음
		if(b1 == b2) {
			System.out.println("b1 == b2 true");
		}
		else {
			System.out.println("b1 == b2 false");
		}
		if(b3 == b4) {
			System.out.println("b3 == b4 true");
		}
		else {
			System.out.println("b3 == b4 false");
		}
	}

}
