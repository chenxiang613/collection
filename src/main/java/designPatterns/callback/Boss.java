package designPatterns.callback;

public class Boss implements CallbackFuncInterface {

	
	@Override
	public void callbackFunc() {
		System.out.println("事情xx搞定了，我要向董事长报告");
	}

}
