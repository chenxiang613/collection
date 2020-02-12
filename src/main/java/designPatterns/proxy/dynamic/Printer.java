package designPatterns.proxy.dynamic;

public class Printer implements IPrintable,IWritable {
	
    public void print() {
        System.out.println("----打印数据!----");
    }

	public void write() {
		System.out.println("----写入数据!----");
	}
    
}