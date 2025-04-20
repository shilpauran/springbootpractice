package com.spring.interview.demo.LamdaExpressions.classes;

import java.util.Optional;

//important methods
/*
* Optional.empty() - generates an empty Optional Container
* Optional.of(val) - creates an optional object of val - if val is null, returns null
* Optional.ofNullable(val)  - does not return null, instead gives an empty object
* Optional.isPresent() - checks if the object is empty or not
* Optional.orElse() - if empty , then allows us to do some operation
* Optional.orElseGet() - same as above, but a lambda way
* Optional.orElseThrow() - if empty, allows us to throw some error
* Optional.ifPresent() - allows us do something if object is not null or empty
* Optional.filter() - allows us to do some conditional check . based on a predicate (a condition) if the condition is not satisfied, the Optional becomes empty.Validate a value conditionally	Only proceed if name is not empty, matches... Avoid nested if-checks	More declarative functional style
* Optional.map() - This method supports post-processing on Optional values, without the need to explicitly check for a return status.
* */
public class OptionalClassDemo {

    //Optional acts as a single value country
    public void init()
    {
        //of , empty, ofNullable - static methods to create an optional object

        //using empty
       Optional<String> emptyObject =  Optional.empty(); //returns empty object of this class

        //using of
        String name = "shilpa";
        Optional<String> optionalS = Optional.of(name); //internally provides a null check . if the given value is null, then it returns the null pointer error

        //using ofNullable
        Optional<String> name1 = Optional.ofNullable(name);//if given value is null, then it returns the empty object of the given class. it wont throw the exception


        //get data from optional
        String derivedName = name1.get();

        //in real time, we dont call directly get(). we use isPresent()
        String value = name1.isPresent() ? name1.get() : "no value present";
        String value1 = name1.orElse("no value present"); //much functional way.
        String value2 = name1.orElseGet(()-> "no value present"); //takes lambda
        String value3 = name1.orElseThrow(()-> new RuntimeException("no value present"));//throws exception

        //ifPresent() method
        Optional<String> gender = Optional.of("Male");
        Optional<String> emptyOptional = Optional.empty();

        gender.ifPresent((s)-> System.out.println("value is present"));
        emptyOptional.ifPresent((s) -> System.out.println("value is not present"));

        //using filter method to achieve something
        String name2 = "Shilpa";

        Optional<String> opS = Optional.of(name2).filter(s->s.contains("abc"));
        String val = opS.map(String::toUpperCase).orElse("not a valid string"); //using map to assign the value.



    }

}
