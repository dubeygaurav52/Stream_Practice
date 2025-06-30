package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermetiateOperations {

	public static void main(String[] args) {
		//Intermediate operations transform a stream into another stream.
		// They are lazy, meaning they don't execute until a terminal operation is invoked.
		
		//1.Filter
		List<String> asList = Arrays.asList("Akshit","Ram","Shyam","Ghanshyam","Akshit");
		Stream<String> filteredStream = asList.stream().filter(x->x.toLowerCase().startsWith("a"));
		System.out.println(filteredStream);
		//No filtering at this point.
		long count = filteredStream.count();
		System.out.println(count);
		
		//2.map
		Stream<String> mapStream = asList.stream().map(String::toLowerCase);
		
		//3.sorted
		Stream<String> sorted = asList.stream().sorted();
		Stream<String> sortedStreamUsingComparator = asList.stream().sorted((a,b)->a.length()-b.length());
		System.out.println(sorted);
		
		//4.distinct
		Stream<String> distinct = asList.stream().distinct();
		System.out.println(distinct);
		
		//5.limit
		System.out.println(Stream.iterate(1, x->x+1).limit(100));
		
		//6.skip
		System.out.println(Stream.iterate(1, x->x+1).skip(10).limit(100));
		
		//7. peak
		//performs an action on each element as it is consumed
		Stream.iterate(1, x->x+1).skip(10).limit(100).peek(System.out::println).count();
		
		//8.flatMap 
		// Handles stream of collection, lists or arrays where each element is itself a collection
		// Flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of element 
		// Transform and flatten element at the same time 
		List<List<String>> listOfLists=Arrays.asList(Arrays.asList("apple","banana"),
				Arrays.asList("orange","kiwi"),
				Arrays.asList("pear","grape"));
		System.out.println(listOfLists.stream().flatMap(x->x.stream()).toList());
	}
}
