package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxNumAndMinList {

    public void maxMin()
    {
        List<Integer> list = Arrays.asList(10,9,8,7,5,6,2,3,4,1);

        int min = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
        int max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();

    }
}
