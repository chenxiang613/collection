package just4test.interfaceExtends;

public interface HumanBehavior {
	public void sleep();
	public void eat();
	default public void play() {
	}
}