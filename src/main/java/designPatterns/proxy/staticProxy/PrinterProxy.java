package designPatterns.proxy.staticProxy;

public class PrinterProxy implements IPrintable{
//    private String name;
    private Printer real;
    public PrinterProxy() {
    	this.real = new Printer();
    }

    public PrinterProxy(String name) {
    	this.real = new Printer();
    	this.real.setPrinterName(name);
    }

    public void setPrinterName(String name) {
        if (this.real!=null){
        	this.real.setPrinterName(name);
        }
    }

    public  String getPrinterName() {
        return this.real.getPrinterName();
    }

    public void print(String string) {
    	System.out.println("proxy加工处理前");
        real.print(string);
        System.out.println("proxy加工处理后");
    }

    
    public static void main(String [] args){
        IPrintable iPrintable=new PrinterProxy("Alice");
        iPrintable.print("Hello ,world");
    }
}