package com.test;

public class TopLevelClass {

    void accessMembers(NestedOuterClass outer) {     
        // Compiler error: Cannot make a static reference to the non-static
        //     field OuterClass.outerField
        // System.out.println(OuterClass.outerField);
        System.out.println(outer.outerField);
        System.out.println(NestedOuterClass.staticOuterField);
    }  
}
