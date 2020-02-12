package designPatterns.decorate.simpleDecorate;


//简单的包装类
public class MilkDecorate implements Drink {
	private Drink drink;
	
	public MilkDecorate(Drink drink) {
		super();
		this.drink = drink;
	}

	@Override
	public int cost() {
		return drink.cost() + 5;
	}

	@Override
	public String info() {
		return drink.info() + "+牛奶";
	}
	

}


