package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/*
skip() - skips the first element
 */
public class FindSecondLargestNumber {

    public void find()
    {
        List<Integer> intList = Arrays.asList(10, 20, 39, 4, 20);

//        return  new java.util.ArrayList<>(intList.stream().sorted(Comparator.reverseOrder()).toList())
//                .get(1);

        //but above one does needs conversion into array list and if duplicates are then it wont work


        int second =  intList.stream()
                .distinct() // remove duplicates
                .sorted(Comparator.reverseOrder()) //sort in reverse order
                .skip(1) //skip the largest element once
                .findFirst()//actually this returns optional. we should check if it is present then only get()
                .get(); //gets the element

        int third = intList.stream().distinct()
                .sorted(Comparator.reverseOrder()).skip(2)
                .findFirst().get();

        int first = intList.stream().distinct().sorted(Comparator.reverseOrder()).findFirst().get();

    }
}
