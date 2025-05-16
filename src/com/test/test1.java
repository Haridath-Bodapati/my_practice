package com.test;

public class test1 extends test {

	static int i = 10;
	private int j = 23;
	
	public static void main(String args[]){
/*	test1 t = new test1();

	int[][] a = new int[3][3];
	
	
	a[0][0]= 1;
	a[0][1]= 2;
	a[0][2]= 3;
	a[1][0]= 4;
	a[1][1]= 5;
	a[1][2]= 6;
	a[2][0]= 7;
	a[2][1]= 8;
	a[2][2]= 9;
	
	int[] b = new int[2];
	
	
	for(int i=0;i<a.length;i++){
		for(int j=0;j<a.length;j++){
			if(i==j){
			System.out.println("The value is i "+i+"The value of j is "+j);
			System.out.println("The value is "+a[i][j]);
			}
		}
	}*/
	
	
	String h = "hari";
	String h1 = "";
	//String s[] = new String[h.length()];
	//int a[][]=new int[2][9];
	
	int startindex = h.length()-1;
	System.out.println("Then value of startIndex is "+startindex);
	for(int i=h.length()-1;i>=0;i--){
		System.out.println("Then value of i is "+i);
		h1 += h.charAt(i);
		System.out.println("Then value is "+h.charAt(i));
		System.out.println("Then value is "+h1);
	}
	
	
	
	}
	
	public static void test(){
		
	}
	
	private void test1(){
		
	}
	
}