package effectivejava.chap2.item2.builderpattern;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Coffee {
	public enum Temperature {ICE, HOT}//온도(아이스, 핫)
	public enum Bean {ETHIOPIA_YIRCHEFFE, GUATEMALA_ANTIGUA, BRAZIL_SANTOS};//원두(에티오피아 예가체프, 과테말라 안티구아, 브라질 산토스)
	public enum Size {SHORT, TALL, GRANDE, VENTI}//사이즈
	public enum Extra {SYRUP, LESS_ICE, MORE_ICE}//부재료(시럽,얼음적게,얼음많이)	
	private final Bean bean;//원두 필수
	private final Temperature temperature;//온도 필수
	private final Size size;//사이즈 필수
	private final int shot;//샷추가 횟수 선택
	private final Set<Extra> extras;//부재료 선택
	
	abstract static class Builder<T extends Builder<T>>{		
		//필수 매개변수
		private final Temperature temperature;
		private final Bean bean;
		private final Size size;
		//선택 매개변수
		private int shot = 0;
		EnumSet<Extra> Extras = EnumSet.noneOf(Extra.class);
		
		public Builder (Bean bean, Temperature temperature, Size size) {
			this.bean = bean;
			this.temperature = temperature;
			this.size = size;
		}
		
		public T shot(int val) {
			this.shot = val;
			return self();
		}
		
		public T addExtra(Extra extra) {
			Extras.add(Objects.requireNonNull(extra));
			return self();
		}
		
		protected abstract T self();
	}
	
	Coffee(Builder<?> builder){
		this.bean = builder.bean;
		this.temperature = builder.temperature;
		this.size = builder.size;		
		this.shot = builder.shot;
		this.extras = builder.Extras.clone();
	}
}
