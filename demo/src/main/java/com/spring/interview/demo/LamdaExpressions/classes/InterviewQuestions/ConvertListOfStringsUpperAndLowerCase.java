package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Arrays;
import java.util.List;

public class ConvertListOfStringsUpperAndLowerCase {

    public void convert()
    {
        List<String> list = Arrays.asList("shilpa", "krishna", "pandu" , "harika");

        List<String> converted = list.stream().map(String::toUpperCase).toList(); //upper case

        List<String> lower = list.stream().map(String::toLowerCase).toList();
    }
}
