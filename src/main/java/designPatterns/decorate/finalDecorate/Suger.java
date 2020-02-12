package designPatterns.decorate.finalDecorate;


//具体装饰类
public class Suger extends AbstractDrinkDecorate {
	
	public Suger(Drink drink) {
		super(drink);
	}

//	@Override
//	public int cost() {
//		return super.cost()+5;
//	}
	
	@Override
	public String info() {
		return super.info() + "+糖(免费)";
	}

}
