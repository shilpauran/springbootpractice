package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Arrays;
import java.util.List;

public class FindTheProductInList {

    public void find()
    {
        List<Integer> nums = Arrays.asList(2, 3, 4, 5);

        int result = nums.stream()
                .reduce(1,(a,b)->a*b); //intial value is 1 and doing cumulative multiply

        /*
            1 * 2 = 2
            2 * 3 = 6
            6 * 4 = 24
            24 * 5 = 120

        */
    }
}
