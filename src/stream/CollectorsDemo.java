package stream;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CollectorsDemo {

	public static void main(String[] args) {
		//Collectors is a utility class
		// Provides a set of  methods to create common collectors
		
		//1.Collecting to list
		List<String> names = Arrays.asList("Anna","Charlie","Bob","David");
		List<String> list = names.stream()
		.filter(name->name.startsWith("A"))
		.collect(Collectors.toList());
		System.out.println(list);
		
		//2.Collecting to set
		List<Integer> nums = Arrays.asList(1,2,3,2,4,3,4,5,6,7);
		Set<Integer> set = nums.stream().collect(Collectors.toSet());
		System.out.println(set);
		
		//3.Collecting to a specified collection
		ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(()->new ArrayDeque<>()));
		
		//4.Joining Strings
		//Concatenates stream into a single string 
		String collect2 = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
		System.out.println(collect2);
		
		//5.Summarizing Data 
		//Generates statistical summary(Count, sum, max, min, average)
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
		IntSummaryStatistics summaryStatistics = numbers.stream().collect(Collectors.summarizingInt(x->x));
		System.out.println("Average: "+summaryStatistics.getAverage());
		System.out.println("Min: "+summaryStatistics.getMin());
		System.out.println("Max: "+summaryStatistics.getMax());
		System.out.println("Count: "+summaryStatistics.getCount());
		System.out.println("Sum: "+summaryStatistics.getSum());
		System.out.println(": "+summaryStatistics);
		
		//6. Calculating averages
		Double collect3 = numbers.stream().collect(Collectors.averagingInt(x->x));	
		System.out.println(collect3);
		
		//7. Counting elements
		Long collect4 = numbers.stream().collect(Collectors.counting());
		System.out.println(collect4);
				
		//8. grouping  elements
		List<String> words = Arrays.asList("hello","world","java","stream","collecting");
		//System.out.println(words.stream().collect(Collectors.groupingBy(x->x.length())));
		System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
		System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(", "))));
		System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.counting())));
		System.out.println(words.stream().collect(Collectors.groupingBy(String::length,TreeMap::new ,Collectors.counting())));
		
		//9.Partitioning Elements
		// Partitions elements into two groups (true and false) based on a predicate
		System.out.println(names.stream().collect(Collectors.partitioningBy(x->x.length()>5)));
		System.out.println(numbers.stream().collect(Collectors.partitioningBy(x->x%2==0)));
		
		//10. Mapping and collecting
		//Applies a mapping function before collecting
		System.out.println(words.stream().collect(Collectors.mapping(x->x.toUpperCase(), Collectors.toList())));
		
	}
}
