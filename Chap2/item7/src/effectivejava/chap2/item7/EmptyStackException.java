package effectivejava.chap2.item7;

public class EmptyStackException extends IllegalStateException{

	@Override
	public String toString() {
		return "스택에서 꺼낼 원소가 존재하지 않습니다.";
	}
	
}
