package effectivejava.chap2.item2;

import effectivejava.chap2.item2.builderpattern.Member;
//import effectivejava.chap2.item2.javabeanspattern.Member;
//import effectivejava.chap2.item2.telescopingconstructorpattern.Member;


public class BuilderPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//점층적 생성자 패턴(telescoping constructor pattern)을 사용하여 생성
		//Member m1 = new Member("a001", "Alice");
		//Member m2 = new Member("a002", "Sam","19950103",27);
		//Member m3 = new Member("a002", "Sam","19960103",26,"A");
		//System.out.println(m1);
		//System.out.println(m2);
		//System.out.println(m3);
		
		//자바빈즈 패턴(JavaBeans pattern)을 사용하여 생성
		//Member m4 = new Member();
		//m4.setId("a001");
		//m4.setName("Alice");
		//System.out.println(m4);
		
		//빌더 패턴(Builder pattern)을 사용하여 생성
		Member m5 = new Member.Builder("a001", "Alice").birth("19940501").age(20).grade("B").build();
		System.out.println(m5);
	}

}
