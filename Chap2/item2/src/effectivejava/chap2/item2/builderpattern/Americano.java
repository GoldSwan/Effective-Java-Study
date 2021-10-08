package effectivejava.chap2.item2.builderpattern;

public class Americano extends Coffee{
	private final boolean syrupInside;//시럽 유무
	
	public static class Builder extends Coffee.Builder<Builder>{
		
		private boolean syrupInside = false;//default
		public Builder(Bean bean, Temperature temperature, Size size) {
			super(bean, temperature, size);
		}		

		public Builder syrupInside() {
			this.syrupInside = true;
			return this;
		}
		@Override 
		public Americano build() {
			return new Americano(this);
		}
		@Override
		protected Builder self() {
			return this;
		}	
	}
	
	private Americano(Builder builder) {
		super(builder);
		syrupInside = builder.syrupInside;
	}

	@Override
	public String toString() {
		return null;
	}
}
