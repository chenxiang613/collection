package designPatterns.proxy.dynamic;

import java.lang.reflect.Proxy;
import java.util.HashMap;

public class Console {

	public static void main(String[] args) {
		//创建被代理类对象
		Printer printer = new Printer();
		//创建handler(增强内容类)
		TransactionHandler handler = new TransactionHandler(printer);
		//借用Proxy类创建代理类，代理类也是实现
		IPrintable proxyPrinter = (IPrintable) Proxy.newProxyInstance(printer.getClass().getClassLoader(), new Class[] { IPrintable.class }, handler);
		IWritable proxyWritable = (IWritable) Proxy.newProxyInstance(printer.getClass().getClassLoader(), new Class[] { IWritable.class }, handler);
		//
		proxyPrinter.print();
		proxyWritable.write();
	}
	
	HashMap<String,String> map = new HashMap<String,String>();

}
