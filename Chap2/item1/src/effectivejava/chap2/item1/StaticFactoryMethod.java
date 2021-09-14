package effectivejava.chap2.item1;

public class StaticFactoryMethod {

	public static class Item {
		private String code = "";
		private String name = "";
		private String group = "";
		public Item () {
			this.code = "defaultItem";
			this.name = "defaultName";
			this.group = "defaultGroup";
		}
		//public 생성자를 제공하여 인스턴스 생성
		public Item (String code, String name, String group) {
			this.code = code;
			this.name = name;
			this.group = group;
		}		
		//정적 팩터리 메서드를 이용한 인스턴스 생성
		public static Item valueOf(String code, String name, String group) {
			Item Item = new Item();
			Item.setCode(code);
			Item.setName(name);
			Item.setGroup(group);
			return new Item();
		}
		private void setCode(String Code) {
			this.code = Code;
		}
		private void setName(String Name) {
			this.name = Name;
		}
		private void setGroup(String Code) {
			this.group = Code;
		}
		public String getCode() {
			return this.code;
		}
		public String getName() {
			return this.name;
		}
		public String getGroup() {
			return this.group;
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item1 = new Item("ITEM0001","과자","식품");
		Item item2 = Item.valueOf("ITEM0002","맥주","음료");
	}

}
