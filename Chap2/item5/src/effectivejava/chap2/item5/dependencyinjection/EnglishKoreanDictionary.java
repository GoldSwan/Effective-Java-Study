package effectivejava.chap2.item5.dependencyinjection;

import java.util.Map;
//영한사전
public class EnglishKoreanDictionary extends Dictionary{
	public static class Builder extends Dictionary.Builder<Builder>{	
		public Builder(Map<String, String> map) {
			super(map);
		}		

		@Override 
		public EnglishKoreanDictionary build() {
			return new EnglishKoreanDictionary(this);
		}
		@Override
		protected Builder self() {
			return this;
		}	
	}
	
	private EnglishKoreanDictionary(Builder builder) {
		super(builder);
	}
}
