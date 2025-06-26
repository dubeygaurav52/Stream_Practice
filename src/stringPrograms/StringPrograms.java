package stringPrograms;

import java.util.HashMap;
import java.util.Map;

public class StringPrograms {
	
	public static void main(String[] args) {

		String s="java program practice hello";
		
	// Reverse word order	
       String [] words=s.split(" ");
       StringBuilder sb=new StringBuilder();
		for(int i=words.length-1;i>=0;i--) {
			sb.append(words[i]).append(" ");
		}
		String s4=sb.toString();
		System.out.println(s4);
	//End
		
		//Remove Duplicate Characters From String using java 8		
		StringBuffer sb2=new StringBuffer();
		s.chars().distinct().forEach(c->sb2.append((char)c));
		System.out.println(sb2);
		//End
		
		//Java Program: Character Occurrence in a String.
		String string="Character Occurrence in a String";
		Map<Character, Integer>charaterCount=new HashMap<>();
		for(char c:string.toCharArray()) {
				charaterCount.put(c, charaterCount.getOrDefault(c, 0)+1);
		}
		for(Map.Entry<Character, Integer> entry : charaterCount.entrySet()) {
		System.out.print(entry.getKey()+": "+entry.getValue());
		}//ends
		
		//Java Program: Count a Particular Character.
		char targetChar = 'r';  // Character to count

        int count = 0;
        for (char c : string.toCharArray()) {
            if (c == targetChar) {
                count++;
            }
        }

        System.out.println("The character '" + targetChar + "' appears " + count + " times.");
		
        String words1 []=s.split(" ");
        StringBuilder result=new StringBuilder();
        for(String word:words1) {
        	StringBuilder reverse=new StringBuilder(word);
        	result.append(reverse.reverse()).append(" ");
        }
        System.out.println(result);
	}
 }
	
	

