package designPatterns.decorate.finalDecorate;


//具体装饰类
public class Milk extends AbstractDrinkDecorate {
	
	public Milk(Drink drink) {
		super(drink);
	}

	@Override
	public int cost() {
		return super.cost()*2;
	}
	
	@Override
	public String info() {
		return super.info() + "+牛奶";
	}

}
