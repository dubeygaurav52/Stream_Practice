package stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {

	public static void main(String[] args) {
		// A type of stream that enables parallel processing of elements
		// Allowing multiple threads to process part of the stream simultaneously
		// This can significantly improve performance for large data set
		// Workload is distributed across multiple threads 
	 long startTime = System.currentTimeMillis();
		List<Integer> list = Stream.iterate(1, x->x+1).limit(20000).toList();
	  List<Long> list2 = list.stream().map(ParallelStream::factorial).toList();
	  long endTime = System.currentTimeMillis();
	  
	  System.out.println("Time taken with sequencial stream: "+(endTime - startTime)+" ms");
	  System.out.println("oyyyy");
	  
	   startTime = System.currentTimeMillis();
	  List<Long> list3 = list.parallelStream().map(ParallelStream::factorial).toList();
	//  List<Long> list4 = list.parallelStream().map(ParallelStream::factorial).sequential().toList();
	   endTime = System.currentTimeMillis();
	  
	  System.out.println("Time taken with parallel  stream: "+(endTime - startTime)+" ms");
	  
	  //Parallel streams are most effective for CPU-intensive or large datasets where tasks are independent
	  //They may add overhead for simple tasks or small datasets
	  
	  //cumulative sum
	  //[1,2,3,4,5,6] --> [1,3,6,10,15,21]
	  List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
	 AtomicInteger sum=new AtomicInteger(0);
	 List<Integer> cumulativeSum = numbers.parallelStream().map(sum::addAndGet).toList();
	 System.out.println("Expected result : [1,3,6,10,15,21]");
	 System.out.println("Actual result with parallel stream"+cumulativeSum);
	}
	
	
	private static long factorial(int n) {
		long result=1;
		for(int i=2;i<=n;i++) {
			result*= i;
		}
		return result;
	}
}
