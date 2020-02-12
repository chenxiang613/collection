package just4test.io;

import java.io.*;


/**
 * 字节数组输入字节流
 * 操作IO流的四个步骤
 * 1、创建源（内存中的数据）
 * 2、选择流
 * 3、具体IO操作
 * 4、释放资源
 */
public class ByteArrayInputOutputStreamTest {
	
	public static void main(String args[]) {
		byte[] byteArray = ByteArrayInputOutputStreamTest.fileToByteArray("D:/Project/gitproject/collection/src/main/java/just4test/io/schedule.png");
		System.out.println(byteArray.length);
		ByteArrayInputOutputStreamTest.byteArrayToFile(byteArray, "D:/Project/gitproject/collection/src/main/java/just4test/io/1.png");
	}
	
	//数据源是内存中的字节数组，测试ByteArrayInputStream
	public static void read(){
		byte[] src = "Talk is cheap, show me the codes.".getBytes();
		try( ByteArrayInputStream bis = new ByteArrayInputStream(src)) {
			byte[] buffer = new byte[4]; 
			while (  bis.read(buffer) != -1 ) {
				String str = new String(buffer, "utf-8");
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
        
	
	//数据流向的目的地是内存总的字节数组，测试ByteArrayOutputStream
	public static void write(){
		//用于装ByteArrayOutputStream中的数据，并打印
		byte[] printByteArray = null;
		//因为数据是从程序流向内存中，而内存中的数据不用我们管理,JVM会开辟一块空间来保存数据，构造ByteArrayOutputStream实例的时候不用传入byte[]数组		
		try( ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
			String str = "My name is JackChen";
			byte[] buffer = str.getBytes();
			bos.write(buffer);
			bos.flush();
			printByteArray = bos.toByteArray();
			System.out.println(new String(printByteArray));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static byte[] fileToByteArray(String fileSrc){
		File file = new File(fileSrc);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try( FileInputStream fis = new FileInputStream(file) ) {
			byte[] buffer = new byte[1024]; 
			int length = 0;
			while ( (length = fis.read(buffer)) != -1 ) {
				bos.write(buffer,0,length);
			}
			bos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bos.toByteArray();
	}
	
	public static void byteArrayToFile(byte[] byteArray,String fileSrc){
		File dest = new File(fileSrc);
		ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
		try( FileOutputStream fos = new FileOutputStream(dest) ) {
			byte[] buffer = new byte[1024]; 
			int length = 0;
			while ( (length = bis.read(buffer)) != -1 ) {
				fos.write(buffer,0,length);
			}
			fos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}