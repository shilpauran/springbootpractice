package com.spring.interview.demo.LamdaExpressions.classes;

import com.spring.interview.demo.LamdaExpressions.classes.interfaces.Printable;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceDemo {

    public static int addition(int a, int b)
    {
        return a+b;
    }
    public void methodRefStaticMethod(){

        //1. method reference to a static method
        Function<Integer,Double> res = (i)-> Math.sqrt(i);
        res.apply(10);

        //replace lambda with method reference
        Function<Integer,Double> res1 = Math::sqrt;
        res1.apply(20);

        //lambda
        BiFunction<Integer,Integer,Integer> res2 = (a,b)-> MethodReferenceDemo.addition(a,b);
        res2.apply(10,20);
        //replace lambda with method reference
        BiFunction<Integer,Integer,Integer> res3 = MethodReferenceDemo::addition;
        res3.apply(20,30);

    }

    public void displayUpperCase(String msg)
    {
            msg = msg.toUpperCase();
            System.out.println(msg);
    }

    //object reference
    public void methodRefObjectMethod(){

        MethodReferenceDemo referenceDemo = new MethodReferenceDemo();

        //lambda expression
        Printable printable = (msg) -> {referenceDemo.displayUpperCase(msg);};
        printable.print("hi this is shilpa");

        //into method reference
        Printable printable1 = referenceDemo::displayUpperCase;
        printable1.print("hi this is shilpa");
    }

    //reference of instance method of an arbitrary object of specific type.
    public void arbitraryObject(){

        //lambda
        Function<String,String> res = (String input)-> input.toUpperCase();
        res.apply("shilpa");

        //method reference
        Function<String,String> res1 = String::toUpperCase;
        res1.apply("krishna");

        //another example

        String[] strings = { "a", "e", "i" , "o", "u", "A", "E","I","O","U"};

        //using lambda . compares each one and sorts
        Arrays.sort(strings,(s1,s2)->s1.compareToIgnoreCase(s2));

        //using method reference
        Arrays.sort(strings,String::compareToIgnoreCase);


    }

    //reference to a Constructor
    public void constRef()
    {
        //convert a list into set
        List<String> fruits = new ArrayList<>();

        fruits.add("apple");
        fruits.add("banana");
        fruits.add("mango");
        fruits.add("pipeapple");
        fruits.add("pipeapple");

        //lambda expression to convert to list
        Function<List<String> , Set<String>> res = (fruitList) -> new HashSet<>(fruitList);
        Set<String> fruitSet = res.apply(fruits);

        //method reference
        Function<List<String> , Set<String>> res1 = HashSet::new;
        Set<String> fruitSet1 = res1.apply(fruits);
    }
}
