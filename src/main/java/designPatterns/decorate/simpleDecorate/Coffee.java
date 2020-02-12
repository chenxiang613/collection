package designPatterns.decorate.simpleDecorate;

public class Coffee implements Drink{
	private int cost = 20;
	private String name = "coffee";
	
	public int cost() {
		return this.cost;
	}

	public String info() {
		return this.name;
	}
}