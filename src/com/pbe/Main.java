package com.pbe;

/** Study on Varargs: Variable-Length arguments
 @author Pieter Beernink
 @version 1.0
 @since 1.0
 */

// *********************
// VARARGS
// *********************
// Varargs, short for variable-length arguments, has been introduced in JDK 5.
// This feature allows methods to take a variable number of arguments, ranging from zero to multiple arguments.

// Previously, variable-length could be handled in two ways:
// 1. Using overloaded methods (one for each situation).
// 2. Using an array as method parameter.
// Varargs can be a better approach, requiring less code.

// When using varargs there are two rules to follow:
// 1. There can be only one variable argument in the method.
// 2. Variable argument (varargs) must be the last parameter.

// Note that it's possible to combine 'regular' parameters with a varargs parameter.

// The syntax for implementing varargs: method(datatype... args) { // method body }
// The three dots simply tell the compiler that varargs will be used.
// The arguments will now be stored in an array referred to be args.

// As with any method, it's possible to overload methods with a varargs parameter.
// However, to prevent ambiguity it's sometimes better to use two different method names instead.


public class Main {

    public static void main(String[] args) {

        // 'Old style' approach to varargs: using an array to pass a variable number of arguments to a method.
        System.out.println("'Old style' approach to varargs");
        int[] array1 = { 5 }; // 1 argument
        int[] array2 = { 1, 2, 3}; // 3 arguments
        int[] array3 = { }; // no arguments - in this case the length of args will be 0

        oldStyleVarargs(array1);
        oldStyleVarargs(array2);
        oldStyleVarargs(array3);

        // Varargs approach
        System.out.println("Varargs approach");
        varargsTest(5); // 1 argument
        varargsTest(1, 2, 3); // 3 arguments
        varargsTest(); // no arguments

        // Varargs example with method that accepts multiple parameters including varargs
        System.out.println("Multiple parameters including varargs");
        varargsTest2(1, 2, 1,2,3); // 3 arguments
        System.out.println();

        // Overloading varargs
        System.out.println("Overloading varargs");
        varargsTest3(1, 2, 3);
        varargsTest3(true, true, false);
        varargsTest3("Varargs test", 5, 10);
    }

    // 'Old style' approach to varargs: using an array to pass a variable number of arguments to a method.
    public static void oldStyleVarargs(int[] a) {
        System.out.println("Number of arguments: " + a.length);
        for (int x : a)
            System.out.print(a + " ");
        System.out.println();
    }

    // Varargs approach
    public static void varargsTest(int ... a) {
        System.out.println("Number of arguments: " + a.length);
        for (int x : a)
            System.out.print(x + " ");
        System.out.println();
    }

    // Varargs example with method that accepts multiple parameters including varargs
    // Note: there can be maximum ONE varargs parameter and it must always be declared last!
    public static void varargsTest2(int a, int b, int ... c) {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Number of arguments: " + c.length);
        for (int x : c) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    // Overloading varargs
    // NOTE that the types of varargs can differ, causing the parameter to be treated as an array of the specified type.
    // Java uses either 1) the type difference to determine which overloaded method to call and/or 2) the number of parameters.
    // Unexpected errors can occur when overloading a method that takes a varargs because it's possible to create an ambiguous call to an overloaded varargs method.
    // For example:
    // - by using methods that use both (int ...) and (boolean ...), making it impossible for the compiler to know which method to use when calling method().
    // - by using methods with (int ... x) and (int a, int ... x) and calling method(1). The compiler will not know which method to call for.
    public static void varargsTest3(int ... a) {
        System.out.println("varargsTest3 with int as parameter");
        System.out.println("No. of args: " + a.length);
        System.out.print("Args contents: ");
        for (int x : a)
            System.out.print(x + " ");
        System.out.println();
        System.out.println();
    }

    public static void varargsTest3(boolean ... a) {
        System.out.println("varargsTest3 with boolean as parameter");
        System.out.println("No. of args: " + a.length);
        System.out.print("Args contents: ");
        for (boolean x : a)
            System.out.print(x + " ");
        System.out.println();
        System.out.println();
    }

    public static void varargsTest3(String a, int ... v) {
        System.out.println("varargsTest3 with String & int varargs as parameter");
        System.out.println("String contents: " + a);
        System.out.println("No. of args: " + v.length);
        System.out.print("Args contents: ");
        for (int x : v)
            System.out.print(x + " ");
        System.out.println();
        System.out.println();
    }
}