package designPatterns.callback;

public class Staff {
	
	public void doSomething(CallbackFuncInterface callbackInterface){
		System.out.println("干上级分配的任务");
		System.out.println("干完活调用callbackFunc()函数，向上级报告");
		callbackInterface.callbackFunc();
	}
}
