package just4test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



/**
 * 字节流
 * 操作IO流的四个步骤
 * 1、创建源
 * 2、选择流
 * 3、具体IO操作
 * 4、释放资源
 */
public class FileInputOutputStreamTest {
	
	public static void main(String args[]) {
		FileInputOutputStreamTest.readTxtFile();
	}
	 
	public static void readTxtFile(){
		File file = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/test02.txt");
		try( FileInputStream fis = new FileInputStream(file)) {
			byte[] buffer = new byte[1024]; 
			int length = 0;
			while (  (length = fis.read(buffer)) != -1 ) {
				String str = new String(buffer,0,length,"utf-8");
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
        
	public static void writeTxtFile(){
		File file = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/test02.txt");
		try( FileOutputStream fos = new FileOutputStream(file,true)) {
			String str = "My name is JackChen";
			byte[] buffer = str.getBytes();
			fos.write(buffer);
			fos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void copyFile(){
		File file = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/schedule.png");
		File dest = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/scheduleCopyByInputStream.png");
		try( FileInputStream fis = new FileInputStream(file);FileOutputStream fos = new FileOutputStream(dest) ) {
			byte[] buffer = new byte[1024]; 
			int length = 0;
			while ( (length = fis.read(buffer)) != -1 ) {
				fos.write(buffer,0,length);
			}
			fos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}