package effectivejava.chap2.item7;

public class Main {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("Alice");
		stack.push("Bob");
		stack.push("Swan");
		
		String strElement = stack.pop().toString();
		System.out.println("pop된 원소:"+strElement);
		Object[] elements = stack.getElements();
		
		//null처리한 pop을 사용할 경우 NullPointerException이 발생한다. 즉 pop된 elements[2] 참조는 가비지 컬렉터가 회수할 것이다.
		//메모리 누수가 발생하는 pop에서는 Swan은 pop됬음에도 불구하고 Swan이 출력된다. 즉 앞으로도 회수가 되지 않을 것이다.
		System.out.println(elements[2].toString());
	}

}
