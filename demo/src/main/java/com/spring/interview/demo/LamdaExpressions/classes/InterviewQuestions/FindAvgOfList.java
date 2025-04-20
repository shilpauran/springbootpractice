package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//average method
//mapToInt
public class FindAvgOfList {

    public void find()
    {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        Double average = list.stream()
                .mapToInt(Integer::intValue) //maps the Integer to primitive int //convert Integer to int
                .average() //take the average
                .getAsDouble(); // get from optional

    }
}
