package effectivejava.chap2.item2.builderpattern;

public class Member {
	private final String id;// 아이디 필수
	private final String name;// 이름 필수
	private final String birth;// 생년월일 선택
	private final int age;// 나이 선택
	private final String grade;// 등급 선택
	// 빌더 클래스

	public static class Builder {
		// 필수 매개변수 선언
		private final String id;
		private final String name;
		// 선택 매개변수 선언
		private String birth = "";
		private int age = 0;
		private String grade = "";

		public Builder(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public Builder birth(String birth) {
			this.birth = birth;
			return this;
		}

		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder grade(String grade) {
			this.grade = grade;
			return this;
		}

		public Member build() {
			return new Member(this);
		}
	}

	private Member(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.birth = builder.birth;
		this.age = builder.age;
		this.grade = builder.grade;
	}

	public String toString() {
		return "{id : " + id + " ,name : "+name+" ,birth : "+birth+" ,age : "+age+" ,grade : "+grade+"}";
	}
}
