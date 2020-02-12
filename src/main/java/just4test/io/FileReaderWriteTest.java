package just4test.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;



/**
 * 字符流
 * 操作IO流的四个步骤
 * 1、创建源
 * 2、选择流
 * 3、具体IO操作
 * 4、释放资源
 */
public class FileReaderWriteTest {
	
	public static void main(String args[]) {
		FileReaderWriteTest.readTxtFile();
	}
	 
	public static void readTxtFile(){
		File file = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/test02.txt");
		try( FileReader fr = new FileReader(file)) {
			char[] buffer = new char[1024]; 
			int length = 0;
			while (  (length = fr.read(buffer)) != -1 ) {
				String str = new String(buffer,0,length);
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
	public static void writeTxtFile(){
		File file = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/test02.txt");
		try( FileWriter fr = new FileWriter(file,true)) {
			String str = "My name is JackChen";
			fr.append(str);
			fr.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void copyFile(){
		File file = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/schedule.png");
		File dest = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/schedulecopy.png");
		try( FileReader fr = new FileReader(file);FileWriter fw = new FileWriter(dest) ) {
			char[] buffer = new char[1024]; 
			int length = 0;
			while ( (length = fr.read(buffer)) != -1 ) {
				fw.write(buffer,0,length);
			}
			fw.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}