package com.test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamTest {
	public static void main(String[] args) {
		int array[] = new int[] {1, 2, 3, 4, 5};
		int[] be = Arrays.stream(array).limit(2).toArray();
	
		Stream<int[]> limitedArray = Stream.of(array).limit(2);
		IntStream intStream = limitedArray.flatMapToInt(Arrays::stream);
		int[] ba = intStream.toArray();
		
		int[] bc = Stream.of(array).limit(2).flatMapToInt(Arrays::stream).toArray();
		Arrays.stream(array).limit(2).forEach(e->System.out.print(e));
		
	}
}
