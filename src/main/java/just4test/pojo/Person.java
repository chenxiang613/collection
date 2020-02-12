package just4test.pojo;

import java.io.Serializable;

/**
 * @author cx
 * @version 1.0 V
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;
    private int age;
    private String name;
    private String sex;
    
	public Person(int age, String name, String sex) {
		super();
		this.age = age;
		this.name = name;
		this.sex = sex;
	}
	public Person() {
		super();
	}
    
    
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", sex=" + sex + "]";
	}
}