package just4test.exception;

import java.io.IOException;
import java.io.Reader;

public class ExceptionConsole {
	//定义一个输入流
	private Reader in;
	
	public static void main(String args[]) {
		try {
			ExceptionConsole io = new ExceptionConsole();
			io.ensureOpen();
		} catch (IOException e) {
			System.out.println("say hi");
		}
	}
	 
	//定义方法，手动抛出异常IOException，目的就是让调用此函数的类或者方法处理IOException异常。
	private void ensureOpen() throws IOException {
		if (in == null)
			throw new IOException("Stream closed");
	}
        
}