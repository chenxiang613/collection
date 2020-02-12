package just4test.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler{

	private Object target;
	
	public TransactionHandler(Object target) {
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("——————————开启事务——————————");
		Object obj = method.invoke(target, args);
		System.out.println("——————————结束事务——————————");
		return obj;
	}

}
