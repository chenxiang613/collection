package just4test.proxy.staticProxy;

public class PrinterProxy implements IPrintable{
    private String name;
    private Printer real;
    public PrinterProxy() {
    }

    public PrinterProxy(String name) {
        this.name = name;
    }

    public synchronized  void setPrinterName(String name) {
        if (real!=null){
          real.setPrinterName(name);
        }
        this.name=name;
    }

    public  String getPrinterName() {
        return name;
    }

    public void print(String string) {
        realize();
        real.print(string);
    }

    private synchronized  void realize() {
        if (real==null){
            real=new Printer(name);
        }
    }
    
    public static void main(String [] args){
        IPrintable iPrintable=new PrinterProxy("Alice");
        System.out.println("现在的名字是"+iPrintable.getPrinterName());
        iPrintable.setPrinterName("Bob");
        System.out.println("现在的名字是"+iPrintable.getPrinterName());
        iPrintable.print("Hello ,world");
    }
}