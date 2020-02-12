package just4test.collection;

import just4test.pojo.Person;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



/**
 * @author chenxiang
 * 比较各种循环遍历的插入删除情况
 */
public class LoopComparingTest {
	
	public static void main(String[] args) {
		Person p1 = new Person(10, "chenxiang", "man");
		Person p2 = new Person(13, "lilei", "man");
		Person p3 = new Person(45, "hanmeimei", "man");
		Person p4 = new Person(3, "yinuo", "man");
		Person p5 = new Person(40, "jack", "man");
		List<Person> list = new LinkedList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);

		/**
		 * 在循环中移除元素（ArrayList和LinkedList都适用）
		 * 
		 * 结论：增强型for循环————不能
		 * 	     for循环————不能，存在漏删的bug，删除不完全
		 * 	     迭代器————可以
		 */
		
		/**
		 * 增强型for循环内，在符合某项判断条件的情况下List容器无法正确移除对应的元素
		 */
//		for (Person person : list) {
//			if (person.getAge() > 9) {
//				list.remove(person);
//			}
//		}
		
		/**
		 * for循环内，在符合某项判断条件的情况下List容器无法正确移除对应的元素，存在漏删的bug
		 */
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getAge() > 9) {
//				list.remove(i);
//			}
//		}
		
		/**
		 * while循环内，在符合某项判断条件的情况下，迭代器可以正确移除对应的元素
		 */
		Iterator<Person> it = list.iterator();
		while( it.hasNext() ){
			if( it.next().getAge() > 9){
				it.remove();
			}
        }
		
		/**
		 * 在循环中插入元素（ArrayList和LinkedList都适用）
		 * 
		 * 结论：增强for循环————不能
		 * 	     for循环————不能
		 * 	     迭代器————不能
		 */
		
		/**
		 * 增强型for循环内，在符合某项判断条件的情况下List容器无法正确插入某个特定的元素
		 */
//		for (Person person : list) {
//			if (person.getAge() > 43) {
//				list.add(new Person(30, "tom", "man"));
//			}
//		}
		
		/**
		 * for循环内，在符合某项判断条件的情况下List容器无法正确插入某个特定的元素，只能全部插入在list的尾部
		 */
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getAge() > 39) {
//				list.add(new Person(30, "tom", "man"));
//			}
//		}
		
		/**
		 * while循环内，在符合某项判断条件的情况下，迭代器无法正确添加特定的元素
		 */
//		Iterator<Person> it = list.iterator();
//		while( it.hasNext() ){
//			if( it.next().getAge() > 42){
//				list.add(new Person(30, "tom", "man"));
//			}
//        }
		
		for (Person integer : list) {
			System.out.println(integer);
		}
	}
}
