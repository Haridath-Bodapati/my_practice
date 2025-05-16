package com.test;

public class HCF {

	public static void main(String[] args) {
		int hcf = getHCF(16, 32);
		System.out.println("The HCF is "+ hcf);

	}

	private static int getHCF(int i, int j) {
		int minimum = Math.min(i, j);
		if(i % minimum == 0 && j % minimum == 0) {
			return minimum;
		}
		
		for(int k = 2; k <= minimum / 2; k ++) {
			if(i % k == 0 && j % k == 0) {
				return k;
			}
		}
		
		
		return 1;
	}

	/*
	 * private static int getHCF(int i, int j) { int minimum = Math.min(i, j); if(i
	 * % minimum == 0 && j % minimum ==0) return minimum; for(int k =2; k <=
	 * minimum/2; k++ ) { if(i % k == 0 && j % k ==0) { return k; } }
	 * 
	 * return 1; }
	 */

	
}
