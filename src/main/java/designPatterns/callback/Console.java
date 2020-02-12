package designPatterns.callback;


public class Console  {  
    
    public static void main(String[] args) {  
    	Staff staff = new Staff();
    	//用匿名函数的方式实现匿名函数，并传入引用
    	staff.doSomething(new CallbackFuncInterface() {  
			@Override
			public void callbackFunc() {
				System.out.println("事情xx搞定了，我要向董事长报告");
			}  
        });
    }  
}  

