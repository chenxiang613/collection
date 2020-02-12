package designPatterns.callback;

public class Supervisor implements CallbackFuncInterface {

	@Override
	public void callbackFunc() {
		System.out.println("事情xx项目搞定了，我要向老板汇报");
	}

}
