package designPatterns.decorate.finalDecorate;

/**
 * 装饰模式的四要素
 * 1.接 Drink
 * 2.接口实现类coffee(被装饰类)
 * 3.抽象装饰类DrinkDecorate(抽象类实现Drink接口并持有Drink属性
 * 4.具体装饰类Suger
 */
public class Console {
	public static void main(String[] args) {
		Drink drink = new Coffee();
		Drink milkDecorate = new Milk(drink);
		Drink sugerMilkDecorate = new Suger(milkDecorate);
		Drink suger2MilkDecorate = new Suger(sugerMilkDecorate);
		Drink suger3MilkDecorate = new Suger(suger2MilkDecorate);
		System.out.println("您的： " + suger3MilkDecorate.info() + "，总价是" + suger3MilkDecorate.cost());
	}
}
