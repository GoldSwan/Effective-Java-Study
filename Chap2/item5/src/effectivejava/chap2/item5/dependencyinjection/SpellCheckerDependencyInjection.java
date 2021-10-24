package effectivejava.chap2.item5.dependencyinjection;

import java.util.Objects;
//의존 객체 주입 방식
public class SpellCheckerDependencyInjection {
	//의존 객체 주입을 했으므로 EnglishKoreanDictionary, KoreanDictionary전부 사용할 수 있다. 또한 이후에 다른 언어 사전이 추가되어도 사용 가능하다.
	private final Dictionary dictionary;
	
	public SpellCheckerDependencyInjection(Dictionary dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	}
	public boolean isVaild(String word) {
		return dictionary.getMap().containsKey(word) ? true : false; 
	}
	public String getMeaning(String word) {
		String meaning = dictionary.getMap().get(word);	
		return (meaning == null) ? "없는 단어 입니다." : meaning;
	}
	public String getChineseCharacter(String word) {
		String meaning = "";
		try {
			KoreanDictionary koreanDictionary = (KoreanDictionary)dictionary;//getChineseCharacterMap 호출을 위한 부모 -> 자식타입 형변환
			meaning = koreanDictionary.getChineseCharacterMap().get(word);
		}catch(ClassCastException e) {
			//KoreanDictionary 외의 사전 객체로 접근했을 경우 예외처리
			return "현재사전에서 사용 불가능한 기능입니다.";		
		}
		return (meaning == null) ? "한자어가 아닙니다." : meaning;
	}
}
