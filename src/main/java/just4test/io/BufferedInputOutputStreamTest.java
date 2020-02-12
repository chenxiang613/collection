package just4test.io;

import java.io.*;



/**
 * 缓冲字节输入流、缓冲字节输出流
 * 作用：提高流的性能
 * 用法：套在字节流上面即可，装饰模式的用法
 * copyFile复制80M文件耗时1517毫秒左右（用了缓冲byte[] buffer = new byte[10]）
 * copyFile复制80M文件耗时800毫秒左右（用了缓冲byte[] buffer = new byte[1024]）
 * copyFileByBuffered套了BufferedInputStream、BufferedOututStream之后，复制80M文件耗时400毫秒左右
 */
public class BufferedInputOutputStreamTest {
	
	public static void main(String args[]) {
		long t1= System.currentTimeMillis();
		BufferedInputOutputStreamTest.copyFile();
		long t2= System.currentTimeMillis();
		System.out.println(t2-t1);

	}
	 
	public static void readTxtFile(){
		File file = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/test02.txt");
		try( FileInputStream fis = new FileInputStream(file);) {
			byte[] buffer = new byte[1024]; 
			while (  fis.read(buffer) != -1 ) {
				String str = new String(buffer, "utf-8");
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
	
	public static void copyFileByBuffered(){
		File file = new File("D:/Project/1.zip");
		File dest = new File("D:/Project/2.zip");
		try( BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
			byte[] buffer = new byte[10];
			int length = 0;
			while ( (length = bis.read(buffer)) != -1 ) {
				bos.write(buffer,0,length);
			}
			bos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void copyFile(){
		File file = new File("D:/Project/1.zip");
		File dest = new File("D:/Project/2.zip");
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