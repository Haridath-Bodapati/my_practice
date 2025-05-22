package com.test.wise;

import java.util.List;
import java.util.Objects;

/**
 * Please give solution for the below problem in java with best space complexity and time complexity, which covers all cases and also solution should cover all the edge cases, handling exceptions, handling null Inputs and invalid inputs. Give the solution as per the below method signature. Please give me the solution using java streams if that is possible.

Alex has a list of items to purchase at a market. The owner offers to discount each item after the first one by the lowest marked price among the prior items. No item's price can be discounted below 0, and the list of items may not be reordered. Calculate the payable amount.

ALL

Example

prices = [2, 5, 1, 4]

Alex pays 2 for the first item since there are no previous items to compare to.

The second item costs 5-2=3.

The third item is free: max(1-min(2, 5), 0) = max(-1, 0) = 0.

The fourth item costs 4-1=3.

The total cost to purchase all items is 2+3+0+3= 8.

The first item is never discounted and the minimum cost of any item is 0.

Function Description

Complete the function calculateAmount in the editor below. The function must return Alex's total cost to purchase all the items.

calculateAmount has the following parameter(s): int prices[n]: the original prices of each of the items selected

Returns:

long int: the total cost to purchase the items after any discounts are applied

Constraints

1≤ n ≤105
*/


public class DiscountCalculator {

    public static long calculateAmount(List<Integer> prices) {
    	
    	long total = 0l;
    	
    	try {
    		
    		// Validate the list itself
    		if (Objects.isNull(prices)) {
    			throw new IllegalArgumentException("Input price list cannot be null.");
    		}
    		
    		int pricesSize = prices.size();
    		if (pricesSize == 0) {
    			return 0L;
    		}
    		
    		// Validate first element
    		Integer firstPrice = prices.get(0);
    		if (firstPrice == null || firstPrice < 0) {
    			throw new IllegalArgumentException("Invalid price at index 0.");
    		}
    		
    		total = firstPrice;
    		int minSoFar = firstPrice;
    		
    		for (int i = 1; i < pricesSize; i++) {
    			Integer price = prices.get(i);
    			if (price == null || price < 0) {
    				throw new IllegalArgumentException("Invalid price at index " + i);
    			}
    			
    			int discounted = Math.max(price - minSoFar, 0);
    			total += discounted;
    			
    			if (price < minSoFar) {
    				minSoFar = price;
    			}
    		}
    	} catch (Exception e) {
    		
    	}

        return total;
    }

    // Example usage
    public static void main(String[] args) {
        List<Integer> prices = List.of(2, 5, 1, 4);
        long amount = calculateAmount(prices);
        System.out.println("Total amount payable: " + amount); // Expected: 8
    }
}

