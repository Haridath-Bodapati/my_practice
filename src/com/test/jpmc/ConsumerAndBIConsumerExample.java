package com.test.jpmc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ConsumerAndBIConsumerExample {

	public static void main(String[] args) {
		// Consumer Example: prints a name in uppercase
		Consumer<String> printUpperCase = name -> System.out.println("Uppercase Name: " + name.toUpperCase());

		printUpperCase.accept("Haridath"); // Output: Uppercase Name: HARIDATH
		
		

		// BiConsumer Example: adds two integers and prints the result
		BiConsumer<Integer, Integer> addAndPrint = (a, b) -> System.out.println("Sum: " + (a + b));

		addAndPrint.accept(10, 20); // Output: Sum: 30
		
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		
		// Consumer to print each name in uppercase
		Consumer<String> printUpper = name -> System.out.println(name.toUpperCase());
		
		names.forEach(printUpper);
		
		Map<String, Integer> scores = new HashMap<>();
		scores.put("Alice", 85);
		scores.put("Bob", 92);
		scores.put("Charlie", 78);
		
		// BiConsumer to print name and score
		BiConsumer<String, Integer> printScore = (name, score) ->
		System.out.println(name + "'s score: " + score);
		
		scores.forEach(printScore);
		
		//Predicate
		Predicate<Integer> isEven = num -> num % 2 == 0;

        System.out.println("Is 10 even? " + isEven.test(10)); // true
        System.out.println("Is 7 even? " + isEven.test(7));   // false
        
        //Supplier
        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100); // 0 to 99

        System.out.println("Random number: " + randomNumberSupplier.get());
        System.out.println("Another random number: " + randomNumberSupplier.get());
	}
}
