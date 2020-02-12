package designPatterns.proxy.staticProxy;

public interface IPrintable {
    public  void setPrinterName(String name);
    public  String getPrinterName();
    public  void print(String string);
}
