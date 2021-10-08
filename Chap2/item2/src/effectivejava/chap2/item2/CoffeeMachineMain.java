package effectivejava.chap2.item2;

import effectivejava.chap2.item2.builderpattern.*;

public class CoffeeMachineMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Americano americano = new Americano.Builder(Coffee.Bean.GUATEMALA_ANTIGUA, Coffee.Temperature.ICE, Coffee.Size.GRANDE)
				.addExtra(Coffee.Extra.MORE_ICE)
				.syrupInside()
				.build();
	}

}
