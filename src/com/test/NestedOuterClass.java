package com.test;

public class NestedOuterClass {

    String outerField = "Outer field";
    static String staticOuterField = "Static outer field";

    class InnerClass {
        void accessMembers() {
            System.out.println(outerField);
            System.out.println(staticOuterField);
        }
    }
    
    private class InnerClass1 {
        int y = 5;
    }

    static class StaticNestedClass {
        void accessMembers(NestedOuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field outerField
            // System.out.println(outerField);
            System.out.println(outer.outerField);
            System.out.println(staticOuterField);
        }
    }

    public static void main(String[] args) {
        System.out.println("Outer class:");
        System.out.println("------------");
        NestedOuterClass outerObject = new NestedOuterClass();
        
        System.out.println("Nested class:");
        System.out.println("------------");
        NestedOuterClass.InnerClass innerObject = outerObject.new InnerClass();
        innerObject.accessMembers();
        
        System.out.println("\nNon Static nested class:");
        System.out.println("--------------------");
        NestedOuterClass.StaticNestedClass topLevelObject = new StaticNestedClass();        
        topLevelObject.accessMembers(outerObject);
        
        
        System.out.println("\n:");
        System.out.println("--------------------");
        StaticNestedClass staticNestedObject = new StaticNestedClass();        
        staticNestedObject.accessMembers(outerObject);

        NestedOuterClass.InnerClass1 myInner = outerObject.new InnerClass1();
        //System.out.println(innerObject.y + outerObject.x);
    }
}