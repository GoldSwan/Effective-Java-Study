package effectivejava.chap2.item5.dependencyinjection;

import java.util.Map;
//국어사전
public class KoreanDictionary extends Dictionary{
	private final Map<String, String> chineseCharacterMap;//한자검색용 map
	public static class Builder extends Dictionary.Builder<Builder>{	
		//선택 매개변수
		private Map<String, String> chineseCharacterMap = null;//한자검색용 map
		public Builder(Map<String, String> map) {
			super(map);
		}		

		public Builder chineseCharacterMap(Map<String, String> chineseCharacterMap) {
			this.chineseCharacterMap = chineseCharacterMap;
			return this;
		}
		
		public Builder addChineseCharacterWord(String word, String chineseCharacter) {
			chineseCharacterMap.put(word, chineseCharacter);
			return self();
		}
		
		@Override 
		public KoreanDictionary build() {
			return new KoreanDictionary(this);
		}
		@Override
		protected Builder self() {
			return this;
		}	
	}
	
	private KoreanDictionary(Builder builder) {
		super(builder);
		this.chineseCharacterMap = builder.chineseCharacterMap;
	}
	
	public Map<String, String> getChineseCharacterMap(){
		return chineseCharacterMap;
	}
}
