package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Java8Demo {

	public static void main(String[] args) {
		//Lambda Expression is an anonymous function
		
		//Predicate -->Functional interface (Boolean valued function) 
		Predicate<Integer> isEven=x->x%2==0;
		System.out.println(isEven.test(4));
		
		Predicate<String> isStartWith=x->x.toUpperCase().startsWith("G");
		Predicate<String> isEndWith=x->x.toUpperCase().endsWith("V");
		//System.out.println(isStartWith.test("Aman"));
		Predicate<String> predicate = isStartWith.and(isEndWith);
		System.out.println(predicate.test("Gaurav"));
		
		//Function -->Work for you
		Function<Integer, Integer> doubleIt=x->x*2;
		Function<Integer, Integer> tripleIt=x->x*3;
		System.out.println(doubleIt.apply(20));
		System.out.println(doubleIt.andThen(tripleIt).apply(20));
		System.out.println(tripleIt.andThen(doubleIt).apply(20)); //same as below
		System.out.println(doubleIt.compose(tripleIt).apply(20)); //same as above
		Function<Integer, Integer> identity = Function.identity();
		System.out.println(identity.apply(5));
		
		//Consumer 
		Consumer<Integer> consumer=x->System.out.println(x);
	consumer.accept(50);
	
	List<Integer> list = Arrays.asList(1,2,3,4,5);
	Consumer<List<Integer>> printList=x->{
		for(int i:x) {
			System.out.println(i);
		}
	};
	printList.accept(list);
	
	//Supplier
	Supplier<String> giveHelloWorld=()->"Hello World";
	System.out.println(giveHelloWorld.get());
	
	//combined example
	Predicate<Integer> predicate2=x->x%2==0;
	Function<Integer, Integer> function=x->x*x;
	Consumer<Integer> consumer2=x->System.out.println(x);
	Supplier<Integer> supplier=()->100;
	
	if(predicate2.test(supplier.get())) {
		consumer2.accept(function.apply(supplier.get()));
	}
	
	//Bi-Predicate, BiConsumer, BiFunction 
	BiPredicate<Integer, Integer> isSumEven=(x,y)->(x+y)%2==0;
	System.out.println(isSumEven.test(5, 6));
	
	BiConsumer<Integer, Integer> biConsumer=(x,y)->{
		System.out.println(x);
		System.out.println(y);
		};
		biConsumer.accept(20, 30);
		
		BiFunction<String, String, Integer> biFunction=(x,y)->(x+y).length();
		System.out.println(biFunction.apply("a", "bc"));
		
		//UnaryOperator, BinaryOperator
		UnaryOperator<Integer> unaryOperator =x->x*3;
		BinaryOperator<Integer> binaryOperator=(x,y)->x+y;
		System.out.println(binaryOperator.apply(2, 9));
		
		//Method Reference--> Use method without invoking & in place of lambda expression
		List<String> list2 = Arrays.asList("Ram","Shyam","Ghanshyam");
		list2.forEach(x->System.out.println(x));
		list2.forEach(System.out::println);
	}
}
