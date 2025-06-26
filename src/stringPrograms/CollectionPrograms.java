package stringPrograms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
public class CollectionPrograms {

	public static void main(String[] args) {
		String input="Hello Gaurav How are You?";
		Map<Character,Integer> count=new HashMap<>();
		for(char c:input.toCharArray()) {
			count.put(c, count.getOrDefault(c, 0)+1);
		}
		for(Map.Entry<Character, Integer>entry:count.entrySet()) {
			if(entry.getKey().toString().equals("e")) {
			System.out.println("Charater: "+entry.getKey()+" Count: "+entry.getValue());
			}
		}
		
		//Java Program to Reverse a String without changing the order of words.
		
		     String s = "How are you Gaurav?"; 
		     String  words[]=s.split(" ");
		     StringBuilder result=new StringBuilder();
		     for(String word: words) {
		    	 StringBuilder reversed=new StringBuilder(word);
		    	 result.append(reversed.reverse().toString()).append(" ");
		     }
		     System.out.println(result);
		     
		   //Java Program to Reverse a order of words of a given String.
		    StringBuilder result11=new StringBuilder();
		    for(int i=words.length-1;i>=0;i--) {
		    	result11.append(words[i]).append(" ");
		    }
		    System.out.println(" Second Result: "+result11);
		  //Java Program to Reverse a String without changing the order of words using java 8.
		    String result1 = Arrays.stream(s.split(" "))
		            .map(word -> new StringBuilder(word).reverse().toString())
		            .collect(Collectors.joining(" "));
		    System.out.println(result1);
		    
		    //Java Program to remove duplicate from a given String.
		    StringBuilder unique=new StringBuilder();
		    s.chars().distinct().forEach(c->unique.append((char)c));
		    System.out.println(unique);

		    //Java Program To find the occurrence of characters in a given String
		 Map<Character,Integer>count1=new HashMap<>();
		 for(char c:s.toCharArray()) {
			 count1.put(c, count1.getOrDefault(c, 0)+1);
		 }
		 for(Map.Entry<Character, Integer>entry:count1.entrySet()) {
			 System.out.println("Character: "+entry.getKey()+" Count: "+entry.getValue());
		 }
		 
		
		
	}
}
