package com.spring.interview.demo.LamdaExpressions.classes.InterviewQuestions;

import java.time.LocalDate;
import java.time.Period;

//Period class introduced in java 8 to calculate period between 2 times
public class AgeOfPersonBasedOnBirthday {

    public void findAge()
    {
        LocalDate birthday = LocalDate.parse("1993-04-30");

        LocalDate currentDate = LocalDate.now();

        Period age = Period.between(birthday,currentDate);
        System.out.println("you are " + age.getYears()+ " years old");

    }
}
