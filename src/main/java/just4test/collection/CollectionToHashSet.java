package just4test.collection;

import just4test.pojo.Person;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CollectionToHashSet {
    public static void main(String[] args) {
        Person p1 = new Person(10, "chenxiang", "man");
        Person p2 = new Person(13, "lilei", "man");
        Person p3 = new Person(45, "hanmeimei", "man");
        Person p4 = new Person(3, "yinuo", "man");
        List<Person> list = new LinkedList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p1);
/*        for (Person person : list) {
            System.out.println(person.toString());
        }*/
        HashSet<Person> set = new HashSet<Person>(list);
        for (Person p : set) {
            System.out.println(p.toString());
        }
    }
}
