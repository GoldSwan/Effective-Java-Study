package effectivejava.chap2.item2.telescopingconstructorpattern;

public class Member {
	private final String id;//아이디               필수
	private final String name;//이름              필수
	private final String birth;//생년월일       선택
	private final int age;//나이                     선택
	private final String grade;//등급            선택
	
	public Member(String id, String name) {
		this(id, name, "");
	}
	
	public Member(String id, String name, String brith) {
		this(id, name, brith, 0);
	}
	
	public Member(String id, String name, String brith, int age) {
		this(id, name, brith, age, "");
	}
	
	public Member(String id, String name, String brith, int age, String grade) {
		this.id = id;
		this.name = name;
		this.birth = brith;
		this.age = age;
		this.grade = grade;		
	}
}
