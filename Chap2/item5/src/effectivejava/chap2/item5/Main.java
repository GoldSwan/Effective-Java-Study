package effectivejava.chap2.item5;

import java.util.*;

import effectivejava.chap2.item5.dependencyinjection.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map1 = new HashMap<>();
		Map<String,String> map2 = new HashMap<>();
		
		KoreanDictionary koreanDictionary = new KoreanDictionary.Builder(map1).addWord("차", "바퀴가 굴러서 가는 기계").build();//국어사전
		EnglishKoreanDictionary englishDictionary  = new EnglishKoreanDictionary.Builder(map2).addWord("car", "차").build();//영한사전
		
		SpellChecker spellChecker1 = new SpellChecker(koreanDictionary);//국어사전 스펠체크 객체
		SpellChecker spellChecker2 = new SpellChecker(englishDictionary);//영한사전  스펠체크 객체
		
		System.out.println(spellChecker1.isVaild("차"));
		System.out.println(spellChecker2.isVaild("car"));
		System.out.println(spellChecker1.getMeaning("차"));
		System.out.println(spellChecker2.getMeaning("차"));
	}

}
