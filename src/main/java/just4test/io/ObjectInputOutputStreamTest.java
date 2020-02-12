package just4test.io;

import java.io.*;

public class ObjectInputOutputStreamTest {

	public static void input(){
		File file = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/object.txt");
		try( ObjectInputStream ios = new ObjectInputStream(new FileInputStream(file))){
			Object o1 = ios.readObject();
			Object o2 = ios.readObject();
			if( o1 instanceof String ){
				String s1 = (String)o1;
				System.out.println(s1);
			}
			if( o2 instanceof Person ){
				Person s2 = (Person)o2;
				System.out.println(s2.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
	public static void output(){
		File file = new File("D:/Project/gitproject/collection/src/main/java/just4test/io/object.txt");
		Person person = new Person(18,"jackma","male");
		try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject("My name is JackChen");
			oos.writeObject(person);
			oos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		ObjectInputOutputStreamTest.input();
	}
}
