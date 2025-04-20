package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class SquareOfFirstThreeEvenNumbers {

    public void square()
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(6);
        list.add(9);

        list.stream()
                .filter(i->i%2 == 0)
                .limit(3)
                .forEach(i-> System.out.println(Math.sqrt(i))); //square root

        List<Integer> squareRoot = list.stream()
                .filter(i->i%2 == 0)
                .limit(3)
                .map(i-> (int) Math.sqrt(i)).toList(); //using map

        //find square
        List<Integer> square = list.stream()
                .filter(i->i%2 ==0) //filter even numbers
                .limit(3) //limits to first 3
                .map(i-> i* i) //finds square of each
                .toList(); //converts to list
    }
}
