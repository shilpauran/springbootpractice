package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

//reverse each word of a string using streams
//we will first split the words into array of strings and then convert that into streams
//Collectors.joining(" ")
public class ReverseEachWordOfString {

    public void reverse()
    {
        String input = "hi this is shilpa";
        String[] strArray = input.split(" ");

        String result = Arrays
                .stream(strArray)
                .map(word -> {
                   StringBuilder sb = new StringBuilder(word);
                   return sb.reverse().toString();
                })
                .collect(Collectors.joining(" "));

        //or
        String resultString = Arrays.stream(input.split(" ")) //split the string with spaces and store in arrays and convert to stream
                .map(word -> new StringBuilder(word) //map the word to a string builder
                        .reverse().toString()) //reverse it and get it back as string from string builder
                .collect(Collectors.joining(" ")); //again join the array as a string.
    }

}
