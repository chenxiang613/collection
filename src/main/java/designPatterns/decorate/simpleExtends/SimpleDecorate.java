package designPatterns.decorate.simpleExtends;


//简单的包装类
public class SimpleDecorate extends Coffee{
	
	@Override
	public int cost() {
		return super.cost() + 5;
	}

	@Override
	public String info() {
		return super.info() + "+包装加工";
	}
	
	public static void main(String[] args) {
		Coffee coffee = new SimpleDecorate();
		System.out.println("您的： " + coffee.info() + "，总价是" + coffee.cost());
	}

}


