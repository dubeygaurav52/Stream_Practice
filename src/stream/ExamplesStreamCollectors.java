package stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExamplesStreamCollectors {

	public static void main(String[] args) {
		//1.Example : Collecting name by length
		List<String> words = Arrays.asList("hello","world","java","stream","collecting");
		Map<Integer, List<String>> collect = words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(collect);
		
		//2.Example : Counting word occurrences
		String sentence="hello world java stream collecting";
		String[] words1 = sentence.split(" ");
		Stream<String> stream = Arrays.stream(words1);
		System.out.println(stream.collect(Collectors.groupingBy(x->x,Collectors.counting())));
		
		//3.Example: Partitioning Even and odd numbers
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
		System.out.println(numbers.stream().collect(Collectors.partitioningBy(x->x%2==0)));
		
		//4.Example: Summing value in a map
		Map<String , Integer> items=new HashMap<>();
		items.put("Apple", 10);
		items.put("Orange", 15);
		items.put("Banana", 20);
		System.out.println(items.values().stream().reduce(Integer::sum).get());
		System.out.println(items.values().stream().collect(Collectors.summingInt(x->x)));
		
		//5.Example : Creating a Map from string elements using toMap()
		List<String> list = Arrays.asList("Apple","Orange","Banana");
		Map<String, Integer> collect2 = list.stream().collect(Collectors.toMap(x->x.toUpperCase(), x->x.length()));
		System.out.println(collect2);
		
		//6.Example : Creating a Map from string elements
				List<String> list2 = Arrays.asList("Apple","Orange","Banana","Apple","Apple","Banana");
				System.out.println(list2.stream().collect(Collectors.toMap(k->k, v->1,(x,y)->x+y)));
	}
}
