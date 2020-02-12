package designPatterns.decorate.simpleExtends;

public class Coffee {
	private int cost = 20;
	private String name = "coffee";
	
	public int cost() {
		return this.cost;
	}

	public String info() {
		return this.name;
	}
}