package exp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		//get count of empty string
		List<String> results = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		results.stream().forEach(System.out::println);
		
		long count = strings.stream().filter(string -> string.length() == 3).count();
	    System.out.println("Strings of length 3: " + count);
	    
	    strings.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
	    
	    System.out.println(strings.stream().reduce((a,b) -> a + b).get());
	}

}
