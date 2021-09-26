package effectivejava.chap2.item2;

import effectivejava.chap2.item2.telescopingconstructorpattern.Member;

public class BuilderPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1 = new Member("a001", "Alice");
		Member m2 = new Member("a002", "Sam","19950103",27);
		Member m3 = new Member("a002", "Sam","19960103",26,"A");
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
	}

}
