package designPatterns.decorate.simpleDecorate;


//简单的包装类
public class SugerDecorate implements Drink {
	private Drink drink;
	
	public SugerDecorate(Drink drink) {
		super();
		this.drink = drink;
	}

	@Override
	public int cost() {
		return drink.cost() + 5;
	}

	@Override
	public String info() {
		return drink.info() + "+糖";
	}
	
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		SugerDecorate sugerCoffee = new SugerDecorate(coffee);
		Drink milkSugerCoffee = new MilkDecorate(sugerCoffee);
		Drink sugerMilkSugerCoffee = new SugerDecorate(milkSugerCoffee);
		System.out.println("您的： " + sugerMilkSugerCoffee.info() + "，总价是" + sugerMilkSugerCoffee.cost());
	}

}


