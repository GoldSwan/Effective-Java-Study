package effectivejava.chap2.item5.dependencyinjection;

import java.util.*;

public abstract class Dictionary {
	private final Map<String, String> map;
	
	abstract class Builder<T extends Builder<T>>{
		
		private final Map<String, String> map = new HashMap<>();
		
		public Builder() {
			
		}
		
		public T addWord(String word, String meaning) {
			map.put(word, meaning);
			return self();
		}
		
		abstract Dictionary build();
		protected abstract T self();	
	}
	
	Dictionary(Builder<?> builder){
		this.map = builder.map;
	}
	
	public Map<String, String> getMap(){
		return map;
	}
}
