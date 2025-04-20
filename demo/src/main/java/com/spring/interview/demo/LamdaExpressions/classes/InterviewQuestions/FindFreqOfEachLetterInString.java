package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFreqOfEachLetterInString {

    public void find()
    {
        String input = "Hello World";

        Map<Character, Long> map = input.chars() //convert the string into chars streams
                .mapToObj((c) -> (char) c) //cast the object to char
                .collect(
                        Collectors.groupingBy(Function.identity(),Collectors.counting()));//Function.idendity() identifies each characters and counting() maintains its count
    }
}
