package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Arrays;
import java.util.List;

/*
distinct() method to remove duplicates
 */
public class RemoveDuplicates {

   void  removeDups()
    {
        List<Integer> intlist = Arrays.asList(1,2,2,3,4,4,5);

        List<Integer> modifiedList = intlist.stream().distinct().toList();

        //removing duplicates from a string
        List<String> strings = Arrays.asList("shilpa" ,"krishna" , "shilpa");

        List<String> stringList =  strings.stream().distinct().toList();

    }

}
