package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		//Stream Is Feature which is introduced in java 8.
		//Stream is used to process collection of data in a functional and declarative manner.
		//stream simplify data processing 
		//Embrace Functional programming
		//Improve Readability and Maintainability
		//Enable easy parallelism
		
		//What is Stream?
		//A sequence of element supporting functional and declarative programming.
		
		//How to use tream?
		//Source, intermediate operations & terminal operation
		List<Integer> list = Arrays.asList(1,2,3,4,5);//Source
		
		//intermediate operation--> filter(x->x%2==0)
		//terminal operation-->count()
		System.out.println(list.stream().filter(x->x%2==0).count());
		
		//Creating Stream
		//1. From Collection
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);//Source
		Stream<Integer> stream = list1.stream();
		
		//2.From Arrays
		String [] array= {"a","b","c"};
		Stream<String> stream1 = Arrays.stream(array);
		
		//3.Using Stream.of()
		Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);
		
		//4.Infinite streams
		Stream<Integer> stream3 = Stream.generate(()->1).limit(100);
		List<Integer> list2 = Stream.iterate(1, x->x+1).limit(100).collect(Collectors.toList());
		System.out.println(list2);
		
	}
}
