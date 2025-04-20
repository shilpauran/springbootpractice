package com.spring.interview.demo.LamdaExpressions.classes;

import com.spring.interview.demo.LamdaExpressions.classes.interfaces.Addable;
import com.spring.interview.demo.LamdaExpressions.classes.interfaces.LamdaInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class LamdaService {

    public void experiment() {
        //instead of implementing the LamdaInterface and wring inside over ride , we can just use lambda expressions
        LamdaInterface rectangle = () -> System.out.println("in shape : rectangle");
        rectangle.shape();

        //instead of implementing the LamdaInterface and wring inside over ride , we can just use lambda expressions
        LamdaInterface square = () -> System.out.println("in shape : square");
        square.shape();

        //instead of implementing the LamdaInterface and wring inside over ride , we can just use lambda expressions
        LamdaInterface circle = () -> System.out.println("in shape : circle");
        circle.shape();

        //instead of calling circle.shape() we can also use a private print function.
        print(rectangle);
        print(square);
        print(circle);

        //or we can also directly pass the behaviour to the print
        print(() -> System.out.println("in shape : hexagon"));


    }

    private static void print(LamdaInterface lamdaInterface) {
        lamdaInterface.shape();
    }

    //lambda which returns something
    public void addition() {

        Addable result = (a, b) -> (a + b);
//        Addable result1 = Integer::sum;
        result.addition(10, 20);


        //with multiple statements

        Addable result1 = (a, b) -> {

            int c = a + b;
            return c;
        };

        result1.addition(20, 30);
    }

    //runnable functional interface implementation
//    public class Demo implements Runnable{
//    @Override
//     public void run(){
//      s.o.p("run method called...")
//}} this is how we normally implement runnable functinal interface
    public void ThreadExample()
    {
        //classic way
//        Thread thread = new Thread(new Demo());
//        thread.start();

        Runnable runnable = () ->{
            System.out.println("run method called...");
        } ;

        Thread thread = new Thread(runnable);
        thread.start();

//        or
        Thread thread1 = new Thread(() -> System.out.println("run method called"));
        thread1.start();

    }


    //Function<T,R> T - type , R- result is a default functional interface provided in java 8, we will see application of this.
    //we will calculate length of a string
    public void functionMethodExp()
    {
        Function<String, Integer> functionRes =  (i)-> i.length();

//        Function<String, Integer> functionRes = String::length;

        Integer length = functionRes.apply("shilpa");
    }

    //Consumer functional interface
    //accepts a single argument and returns no result
    //has one abstract method called accept(Object) method
    public void consumerExp()
    {
        Consumer<String> consumerRes = (i) -> System.out.println("we are in accept");
        consumerRes.accept("shilpa");
    }

    //Supplier functional interface
    //has get method, returns result but does not take any input
    //used when we need to supply some output to client without any parameters

    public void supplierExp()
    {
        Supplier<LocalDateTime> supplierRes = () -> LocalDateTime.now();
//        Supplier<LocalDateTime> supplierRes = LocalDateTime::now;
    }



}
