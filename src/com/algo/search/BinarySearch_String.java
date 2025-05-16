package com.algo.search;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class BinarySearch_String {

	public static int binarySearch(List<String> list, String target) {
		if (!Objects.isNull(list)) {
			Collections.sort(list);
			int low = 0, high = list.size() - 1, mid;
			while (low <= high) {
				mid = low + (high - low) / 2;
				int res = target.compareTo(list.get(mid));
				if (res == 0)
					return mid;
				if (res > 0)
					// If target is greater than mid, ignore left list
					low = mid + 1;
				// If target is less than mid, ignore right list
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("banana");
		list.add("cherry");
		list.add("date");
		list.add("fig");
		list.add("grape");

		String target = "cherry";
		int result = binarySearch(list, target);

		if (result == -1) {
			System.out.println(target + " not found in the list.");
		} else {
			System.out.println(target + " found at index: " + result);
		}
	}
}
