package just4test.string;

public class StringTest {

	public static String str = "54321";
	
	public static void main(String[] args) {
		System.out.println(StringTest.reverseString3(str.length()));
	}
	
	//反转字符串方法：通过substring()方法从str字符串尾部一个一个拿里面的字符
	public static String reverseString1(){
		String temp = "";
		for (int i = 5; i > 0; i--) {
			//System.out.println();
			temp = temp + str.substring(i-1, i);
		}
		return temp;
	}
	
	//反转字符串方法：通过""空字符串切割字符串目标字符串
	public static String reverseString2(){
		String[] stringArray = str.split("");
		String temp = "";
		for (int i = 5; i > 0; i--) {
			//System.out.println(stringArray[i-1]);
			temp = temp + stringArray[i-1];
		}
		return temp;
	}
	
	//反转字符串方法：通过递归实现字符串反转
	public static String reverseString3(int count){
		if(count <= 1) return str.substring(count-1, count);;
		return str.substring(count-1, count) + reverseString3(--count);
	}
	
}
