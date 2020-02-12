package designPatterns.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Data
public class Cat implements Comparable<Cat>{
	private int height;
	private int weight;
	private static Comparator comparator = new HeightComparator();
	
	@Override
	public int compareTo(Cat o) {
		return comparator.compare(this, o);
	}
	
	public static void main(String[] args) {
		List<Cat> catList = new ArrayList();
		catList.add(new Cat(180,80));
		catList.add(new Cat(170,65));
		catList.add(new Cat(201,112));
		catList.add(new Cat(165,54));
		catList.add(new Cat(168,71));
		Collections.sort(catList);
		for (Cat cat : catList) {
			System.out.println(cat);
		}
	}
}
