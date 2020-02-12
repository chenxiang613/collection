package designPatterns.decorate.finalDecorate;

//具体组件
public class Coffee implements Drink {
	private int cost = 20;
	private String name = "coffee";
	
	@Override
	public int cost() {
		return this.cost;
	}

	@Override
	public String info() {
		return this.name;
	}

}
