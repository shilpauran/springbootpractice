package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//new introductions
/*
Collectors class
Collectors.partitioningBy() - partitions a stream and performs some operation.
 */
public class CheckEvenOrOdd {

        public void check()
        {
            //given a list check how many even numbers are there using streams
            Integer[] a = {1,2,3,4,5};

            List<Integer> evenList = Arrays.stream(a).filter(i -> i%2 == 0 ).toList();
            List<Integer> oddList = Arrays.stream(a).filter(i -> i%2 != 0 ).toList();

            int evenCount = evenList.size();
            int oddCount = oddList.size();


            //better way

            Map<Boolean, Long> countMap = Arrays.stream(a).collect(Collectors.partitioningBy(i-> (i % 2 ==0), Collectors.counting()));

            long even = countMap.get(true);
            long odd = countMap.get(false);


        }
}
