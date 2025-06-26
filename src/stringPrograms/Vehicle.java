package stringPrograms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Vehicle {
public static void main(String[] args) {
	Predicate<Integer> isEven=x->x % 2==0;
	System.out.println(isEven.test(4));
	
	//Predicate -->Functional interface (Boolean Value function)
	Predicate<String> isStratWith=x->x.toLowerCase().startsWith("a");
	Predicate<String> isEndsWith=x->x.toLowerCase().endsWith("t");
	Predicate<String> checkString=isStratWith.and(isEndsWith);
	System.out.println(checkString.test("Ankit"));
	
	//Function--> Work for you
	Function< Integer, Integer> douleIt=x->2* x;
	Function< Integer, Integer> tripleIt=x->3* x;
	System.out.println(douleIt.andThen(tripleIt).apply(20));
	System.out.println(douleIt.compose(tripleIt).apply(20));
	Function<Integer, Integer> identity=Function.identity();
	System.out.println(identity.apply(5));
	
	//Consumer
	Consumer< Integer> print =x-> System.out.println(x);
	print.accept(55);
	List<Integer> list = Arrays.asList(1,2,3,4);
	
	Consumer<List<Integer>> printList=x->{
		for(int i:x) {
		System.out.println(i);
		}
	};
	printList.accept(list);
	
	//Supplier
	Supplier<String> getMsg=()->"Hello Gaurav";
	System.out.println(getMsg.get());
	
	//Combined Example
	Predicate< Integer> predicate=x->x%2==0;
	Function<Integer, Integer> function=x->x*x;
	Consumer<Integer> consumer=x->System.out.println(x);
	Supplier<Integer>supplier=()->100;
	
	if(predicate.test(supplier.get())) {
		consumer.accept(function.apply(supplier.get()));
	}
	
	//Method Reference -->use method without invoking & in place of lambda expression 
	List<String> student = Arrays.asList("Gaurav","Prabhakara","Kiran");
	student.forEach(x->System.out.println(x));
	student.forEach(System.out::println);
	
	//Stream
	//1.Filter
	List<String> asList = Arrays.asList("Gaurav","Prabhakar","Kiran","Raunak","Raunak");
		long count = asList.stream().filter(x->x.startsWith("G")).count();
	System.out.println(count);
	
	//2.Map
	Stream<String> map = asList.stream().map(String::toLowerCase);
	
	//3.Sorted
	Stream<String> sorted = asList.stream().sorted();
	Stream<String> sorted2 = asList.stream().sorted((a,b)->a.length()-b.length());
	
	//4.distinct
	Stream<String> distinct = asList.stream().filter(x->x.startsWith("R")).distinct();
	
	//5.limit
	System.out.println( Stream.iterate(1,x->x+1).limit(100).count());
	
	//6.skip
	System.out.println( Stream.iterate(1,x->x+1).skip(10).limit(100).count());
	
	
	//Terminal Operation
	List<Integer> asList2 = Arrays.asList(1,2,3,4);
	//1.collect
	
	List<Integer> collect = asList2.stream().filter(x->x%2==0).collect(Collectors.toList());
	List<Integer> list2 = asList2.stream().skip(1).toList();
	System.out.println(list2);
	
	//2.forEach
	asList2.stream().forEach(x->System.out.println(x));
	
	//3.reduce : Combines element to produce a single result
	Optional<Integer> reduce = asList2.stream().reduce((x,y)->x+y);
	System.out.println(reduce.get());
	
	//4.count
	
	//5.anyMatch,allMatch and noneMatch
	boolean anyMatch = asList2.stream().anyMatch(x->x%2==0);
	boolean allMatch = asList2.stream().allMatch(x->x>0);
	boolean noneMatch = asList2.stream().noneMatch(x->x<0);
	System.out.println(anyMatch);
	System.out.println(allMatch);
	System.out.println(noneMatch);
	
	//6.findFirst and findAny.
	System.out.println(asList2.stream().findFirst().get());
	System.out.println(asList2.stream().findAny().get());
	
	//Examples
	List<String> asList3 = Arrays.asList("Anna","Charlie","BOb","David");
	System.out.println(asList3.stream().filter(x->x.length()>3).toList());
	
	//Examples
	List<Integer> asList4 = Arrays.asList(6,5,3,2,1,8);
	System.out.println(asList4.stream().map(x->x*x).sorted((a,b)->b-a).toList());
	System.out.println("Max element: "+asList4.stream().max(Comparator.naturalOrder()).get());
	System.out.println("Max element: "+asList4.stream().min(Comparator.naturalOrder()).get());
	//Examples
	List<Integer> asList5 = Arrays.asList(1,2,3);
	System.out.println(asList5.stream().reduce(Integer::sum).get());
	
	//Example
	String sentence="Hello WorLd";
	System.out.println(sentence.chars().filter(x->x=='l').count());
	
	//Parallel Stream
		List<Integer> list3 = Stream.iterate(1, x->x+1).limit(2000).toList();
		
		System.out.println(list3.parallelStream().map(x->factorial(x)).toList());
	
		//
		List<List<String>> asList6 = Arrays.asList(Arrays.asList("Apple","Banana"),Arrays.asList("Orange","kiwi"),Arrays.asList("pear","grapes"));
		System.out.println("Before doing operations: "+asList6);
		List<String> list4 = asList6.stream().flatMap(x->x.stream()).toList();
		System.out.println(list4);
}
public static   int  factorial(int n) {
	int result=1;
	for(int i=2;i<=n;i++) {
		result*=i;
	}
	return result;
}
	
 }

	
 
 
 