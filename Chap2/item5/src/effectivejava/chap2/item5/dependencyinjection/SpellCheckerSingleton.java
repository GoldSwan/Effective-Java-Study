package effectivejava.chap2.item5.dependencyinjection;

import java.util.HashMap;
//enum을 활용한 싱글턴 방식
public enum SpellCheckerSingleton {
	INSTANCE;
	//정적 유틸리티처럼 의존 객체 주입을 하지 않았으므로 EnglishKoreanDictionary 객체는 사용할 수 없다. 또한 이후에 다른 언어사전이 추가되어도 사용 불가능하다.
	private final Dictionary dictionary = new KoreanDictionary.Builder(new HashMap<String,String>()).addWord("차", "바퀴가 굴러서 가는 기계")
			.chineseCharacterMap(new HashMap<String,String>()).addChineseCharacterWord("차", "車").build();
	
	public boolean isVaild(String word) {
		return dictionary.getMap().containsKey(word) ? true : false; 
	}
	public String getMeaning(String word) {
		String meaning = dictionary.getMap().get(word);	
		return (meaning == null) ? "없는 단어 입니다." : meaning;
	}
	public String getChineseCharacter(String word) {
		KoreanDictionary koreanDictionary = (KoreanDictionary)dictionary;//getChineseCharacterMap 호출을 위한 부모 -> 자식타입 형변환
		String meaning = koreanDictionary.getChineseCharacterMap().get(word);
		return (meaning == null) ? "한자어가 아닙니다." : meaning;
	}
}
