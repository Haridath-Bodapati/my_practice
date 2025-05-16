package com.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

final class PrimeNumber {
	
	public boolean isPrimeNumber(int number){
        
        for(int i=2; i<=number/2; i++){
        	System.out.println("The vaule of i is "+i);
        	System.out.println("The vaule of() number is "+number);
        	System.out.println("The vaule of number % i is "+number % i);
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
	
	public static List<Integer> primeNumbersTill(int y) {
		
		long count = Stream.iterate(0, n -> n + 1)
                .limit(1000)
                .filter(PrimeNumber::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);
        return IntStream.rangeClosed(2, y) .filter(x -> isPrime(x)).boxed()
        		.collect(Collectors.toList());
        
	}

	public static boolean isPrime(int number) {

		if (number <= 1)
			return false; // 1 is not prime and also not composite

		//return !IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
		
		//return !IntStream.rangeClosed(2, number/2).anyMatch(i->number % i == 0);
		
		//boolean primeorNot = !IntStream.rangeClosed(2, number/2).anyMatch(i -> number % i == 0);
		
		//return !IntStream.rangeClosed(2, number/2).anyMatch( i -> number % i == 0);
		
		return !IntStream.rangeClosed(2, number).anyMatch( i -> number % i ==0);
		//return IntStream.rangeClosed(2, number).noneMatch( i -> number % i ==0);
		
	}
	
	public void testMethodA(){
		System.out.println("In test method");
		testMethodB();
		System.out.println("In test method");
	}
	
	public void testMethodB(){
		System.out.println("In test method B");
	}
	
	public static void main(String args[]){
		PrimeNumber pn = new PrimeNumber();
		pn.testMethodA();
		for(int i=2;i<5;i++) {
			System.out.println("Then "+i +" is prime "+pn.isPrimeNumber(i));
		}
		
	}


}
