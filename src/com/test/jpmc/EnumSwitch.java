package com.test.jpmc;

public class EnumSwitch {

	record Point(int x, int y) { }
	enum Color { RED, GREEN, BLUE, YELLOW}
	
	public static void main(String[] args) {
		Color color = Color.RED;
		//typeTester(null);
		//typeTester("Test");
		typeTester(color);
		//typeTester(new Point(4,5));
		//typeTester(new Double(0));

	}
	
	static void typeTester(Object obj) {  
        switch (obj) {  
            //case null     -> System.out.println("null");  
            //case String s -> System.out.println("String");
            //case String s1 when s1.length() == 1 -> System.out.println("Short: " + s1);
            case Color.RED                      -> {
										            	System.out.println("RED");
											            System.out.println("RED1");
											            System.out.println("RED2");
										            }
            case Color.GREEN                      -> System.out.println("GREEN");
            case Color.BLUE                      -> System.out.println("BLUE");
            case Color.YELLOW                      -> System.out.println("YELLOW");
            //case String s1                      -> System.out.println(s1);
            //case Color c  -> System.out.println("Color with " + c.values().length + " values");  
            //case Point p  -> System.out.println("Record class: " + p.toString());  
            //case int[] ia -> System.out.println("Array of int values of length" + ia.length);  
            default       -> System.out.println("Something else");  
        }  

	}
	
}
