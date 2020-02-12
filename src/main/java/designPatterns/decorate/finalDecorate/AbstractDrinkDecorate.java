package designPatterns.decorate.finalDecorate;


//抽象装饰类
public abstract class AbstractDrinkDecorate implements Drink {
	private Drink drink;
	
	public AbstractDrinkDecorate(Drink drink) {
		super();
		this.drink = drink;
	}

	@Override
	public int cost() {
		return this.drink.cost();
	}

	@Override
	public String info() {
		return this.drink.info();
	}

}
