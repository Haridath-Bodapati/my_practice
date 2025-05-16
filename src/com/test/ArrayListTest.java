package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		
		final List<String> al = new ArrayList<String>();
		al.add("haridath");
		al.set(0,"haridath1");
		//al = new LinkedList<String>();
		
		Iterator<String> i = al.iterator();
		
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		
		// For unmodifiableList we can add new elements, but we can change the underline list
		List<String> a2 = Collections.unmodifiableList(al);
		//a2.add("Hello");
		
		al.add("Hello");
		al.add("Hello Dath");

		Iterator<String> j = a2.iterator();
		while(j.hasNext()){
			System.out.println(j.next());
		}
	}

}
