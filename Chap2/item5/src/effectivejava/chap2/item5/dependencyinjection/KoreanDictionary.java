package effectivejava.chap2.item5.dependencyinjection;

import java.util.Map;

public class KoreanDictionary extends Dictionary{
	public static class Builder extends Dictionary.Builder<Builder>{	
		public Builder(Map<String, String> map) {
			super(map);
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
	}
}
