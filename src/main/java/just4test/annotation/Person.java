package just4test.annotation;

import java.io.Serializable;

/**
 * @author cx
 * @version 1.0 V
 */
@CxAnnotation(lover="haoren")
public class Person implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;
    private int age;
    private String name;
    private String sex;
	@CxAnnotation(lover="haolei")
    private String nation;
    
	public Person(int age, String name, String sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
	}
	
	public Person() {
		super();
	}
    
}