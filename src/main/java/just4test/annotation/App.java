package just4test.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)  {
		try {
			//声明一个Class类型的变量clazz，用于描述运行时的Person类，clazz不是person的实例，这里要搞清楚
			Class clazz = Class.forName("just4test.annotation.Person");
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("Runtime"+annotation.toString());
                //test git
            }
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Person person = new Person();
		System.out.println(person.getClass().getClassLoader());
		ArrayList<String> strings = new ArrayList<>();
		System.out.println(strings.getClass().getClassLoader());
	}
}
