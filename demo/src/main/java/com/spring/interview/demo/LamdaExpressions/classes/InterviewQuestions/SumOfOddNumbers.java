package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Arrays;
import java.util.List;

public class SumOfOddNumbers {

    public void sum(){

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Integer num = list.stream()
                .filter(i->i%2 != 0) //filter the odd numbers
                .reduce(0,(a,b) -> a+b);  // do the sum

        Integer num1 = list.stream()
                .filter(i->i%2 != 0) //filter the odd numbers
                .reduce(0,Integer::sum);  // do the sum


        List<String> list1 = Arrays.asList("hello", "world", "java");
        List<String> list2 = list1.stream().map(String::toUpperCase).toList();
    }
}
