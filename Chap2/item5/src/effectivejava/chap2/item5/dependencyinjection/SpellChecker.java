package effectivejava.chap2.item5.dependencyinjection;

import java.util.Objects;

public class SpellChecker {
	private final Dictionary dictionary;
	
	public SpellChecker(Dictionary dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	}
	public boolean isVaild(String word) {
		return dictionary.getMap().containsKey(word) ? true : false; 
	}
	public String getMeaning(String word) {
		String meaning = dictionary.getMap().get(word);	
		return (meaning == null) ? "없는 단어 입니다." : meaning;
	}
}
