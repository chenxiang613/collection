package designPatterns.proxy.staticProxy;

public class Printer implements IPrintable {
    private String name;

    public Printer() {
    	
    }

    public Printer(String name) {
        this.name = name;
    }

    public void setPrinterName(String name) {
        this.name=name;
    }

    public String getPrinterName() {
        return name;
    }

    public void print(String string) {
        System.out.println("======== "+name+" ========");
        System.out.println(string);
    }

}
