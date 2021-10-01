package effectivejava.chap2.item2.javabeanspattern;

public class Member {
	private String id;//아이디               필수
	private String name;//이름              필수
	private String birth;//생년월일       선택
	private int age;//나이                     선택
	private String grade;//등급            선택
	
	public Member() {}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String toString() {
		return "{id : " + id + " ,name : "+name+" ,birth : "+birth+" ,age : "+age+" ,grade : "+grade+"}";
	}
}
