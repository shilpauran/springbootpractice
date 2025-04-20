package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindLongestString {

    public void find()
    {
        List<String> list = Arrays.asList("apple", "banana", "pear", "grape");

        String longest = list.stream().reduce("",(a,b)-> a.length() > b.length() ? a : b);

        Optional<String> longest1 = list.stream().reduce((a, b)-> a.length() > b.length() ? a : b);
        longest1.ifPresent(System.out::println);
    }
}
