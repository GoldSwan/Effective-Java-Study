package effectivejava.chap2.item5;

import java.util.*;
import effectivejava.chap2.item5.dependencyinjection.*;

public class Main {

	public static void main(String[] args) {
		//정적 유틸리티 - KoreanDictionary만 사용가능
		System.out.println(SpellCheckerStaticUtils.isVaild("차"));
		System.out.println(SpellCheckerStaticUtils.getMeaning("차"));
		System.out.println(SpellCheckerStaticUtils.getMeaning("car"));
		System.out.println(SpellCheckerStaticUtils.getChineseCharacter("차"));
		//싱글턴- KoreanDictionary만 사용가능
		System.out.println(SpellCheckerSingleton.INSTANCE.isVaild("차"));
		System.out.println(SpellCheckerSingleton.INSTANCE.getMeaning("차"));
		System.out.println(SpellCheckerSingleton.INSTANCE.getMeaning("car"));
		System.out.println(SpellCheckerSingleton.INSTANCE.getChineseCharacter("차"));
		
		//의존 객체 주입 - KoreanDictionary, EnglishKoreanDictionary 모두 사용 가능, 이후 다른 언어사전이 추가되어도 사용 가능
		KoreanDictionary koreanDictionary = new KoreanDictionary.Builder(new HashMap<String,String>()).addWord("차", "바퀴가 굴러서 가는 기계")
											.chineseCharacterMap(new HashMap<String,String>()).addChineseCharacterWord("차", "車").build();//국어사전
		EnglishKoreanDictionary englishDictionary  = new EnglishKoreanDictionary.Builder(new HashMap<String,String>()).addWord("car", "차").build();//영한사전
		
		SpellCheckerDependencyInjection spellChecker1 = new SpellCheckerDependencyInjection(koreanDictionary);//국어사전 스펠체크 객체
		SpellCheckerDependencyInjection spellChecker2 = new SpellCheckerDependencyInjection(englishDictionary);//영한사전 스펠체크 객체
		//국어사전
		System.out.println(spellChecker1.isVaild("차"));
		System.out.println(spellChecker1.getMeaning("차"));
		System.out.println(spellChecker1.getMeaning("car"));
		System.out.println(spellChecker1.getChineseCharacter("차"));
		//영한사전
		System.out.println(spellChecker2.isVaild("차"));
		System.out.println(spellChecker2.getMeaning("차"));
		System.out.println(spellChecker2.getMeaning("car"));
		System.out.println(spellChecker2.getChineseCharacter("차"));
	}

}
