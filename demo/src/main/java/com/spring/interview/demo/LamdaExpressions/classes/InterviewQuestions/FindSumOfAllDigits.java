package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Comparator;
import java.util.stream.Stream;

//new methods
/*
convert to string first and get chars
then map and covert to again numeric value.
and add
 */
public class FindSumOfAllDigits {

    public void findSum()
    {
        int input = 123456;

        //convert this into string first
        int input1 = String.valueOf(input).chars()
                .map(ch->Character.getNumericValue(ch))
                .sum();

        //method reference
        int input2 = String.valueOf(input)
                .chars()
                .map(Character::getNumericValue)
                .sum();



    }
}
