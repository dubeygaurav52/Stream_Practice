package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperation {

	public static void main(String[] args) {
		List<Integer> asList = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		//1.collect
		List<Integer> list = asList.stream().skip(1).collect(Collectors.toList());
		List<Integer> list1 = asList.stream().skip(1).toList();
		
		//2.forEach
		asList.forEach(System.out::println);
		
		//3.reduce : Combines element to porduce a single result 
		//Optional<Integer> reduce = asList.stream().reduce((x,y)-> x + y);
		Optional<Integer> reduce = asList.stream().reduce(Integer::sum);
		System.out.println(reduce.get());
		
		//4.count
		
		//5. anyMatch, allMatch, noneMatch
		System.out.println(asList.stream().allMatch(x->x>0));
		System.out.println(asList.stream().anyMatch(x->x%2==0));
		System.out.println(asList.stream().noneMatch(x->x<0));
		asList.stream().allMatch(x->x>0);
		asList.stream().anyMatch(x->x%2==0);
		asList.stream().anyMatch(x->x<0);
		
		//6.findFist, findAny
		System.out.println(asList.stream().findFirst().get());
		System.out.println(asList.stream().findAny().get());
		
		//7.toArray()
		Object[] array = Stream.of(1,2,3,4,5,6,7,8,9).toArray();
		
		//8.min /max
		 System.out.println("Max no: "+Stream.of(1,2,3,4,5,6,7,8,9).max(Comparator.naturalOrder()).get());
		 System.out.println("Min no: "+Stream.of(1,2,3,4,5,6,7,8,9).min(Comparator.naturalOrder()).get());
		
		 //9.forEachOrdered
		 List<Integer> asList4 = Arrays.asList(1,2,3,4,5,6,7,8,9);
			System.out.println("Using forEach with parallel stream: ");
			asList4.parallelStream().forEach(System.out::println);
			System.out.println("Using forEachOrdered  with parallel stream: ");
			asList4.parallelStream().forEachOrdered(System.out::println);
			
		 //Examples
		List<String> asList2 = Arrays.asList("Anna","Charlie","Bob","David");
		System.out.println(asList2.stream().filter(x->x.length()>3).toList());
		
		//Example: Squaring and sorting Numbers
		List<Integer> asList3 = Arrays.asList(2,4,1,8,3,9,5,7,6);
		asList3.stream().map(x->x*x).sorted().toList();
		System.out.println(asList3.stream().map(x->x*x).sorted((a,b)->b-a).toList());
		
		//Example: Summing values
		System.out.println(asList3.stream().reduce(Integer::sum).get());
		
		//Example: Counting occurrence of character
		String sentence="Hello world";
		System.out.println(sentence.chars().filter(x -> x == 'l').count());
		
		//Example
		//Streams cannot be reused after a terminal operation has been called 
		Stream<String> stream = asList2.stream();
		stream.forEach(System.out::println);
		//stream.map(String::toLowerCase).toList();//Exception 
	}
}
