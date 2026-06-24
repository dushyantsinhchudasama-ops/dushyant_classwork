package com.tss.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamTest {
    public static void main(String[] args) {

        List<String> students = Arrays.asList(
                "Amit Tiwari",
                "Rahul Sharma",
                "Sneha Patil",
                "Ankit Verma",
                "Ravi Kumar",
                "Amit Tiwari",
                "Pooja Mehta",
                "Neha Singh"
        );

        //print the name of Student
        //students.stream().forEach(System.out::println);

        //count
        Long count = students.stream().count();

        //create list of unique students name
        List<String> uniqueList = students.stream().distinct().toList();

        students.stream().sorted().distinct().toList();

        students.stream().sorted((Comparator.reverseOrder())).distinct().toList().forEach(System.out::println);

        //first letter start with a
        students.stream().filter(name -> name.split(" ")[0].startsWith("A")).forEach(System.out::println);

        //name more than 10 chars
        students.stream().filter((name)->name.length()>10).forEach(System.out::println);

        //convername in upper case and store in new list
        List<String> uppercaseNames = students.stream().map((name)->name.toUpperCase()).toList();

        //convernames in lowercase and store it in a new list
        List<String> lowercaseNames = students.stream().map((name)->name.toLowerCase()).toList();

        //extract first names and store in a new list
        List<String> firstNames = students.stream().map((name)-> name.split(" ")[0]).toList();
        System.out.println(firstNames);

        //total number of unique students name
        Long uniqueCount = students.stream().distinct().count();
        System.out.println(uniqueCount);

        //find the longest student name
        String longestName = students.stream().max(Comparator.comparing(String::length)).orElse(" ");
        System.out.println(longestName);

        //find the smallest student name
        String smallestName = students.stream().min(Comparator.comparing(String::length)).orElse(" ");
        System.out.println(smallestName);

        //total count of all students names character
        int countOfCharacter = students.stream().mapToInt(String::length).sum();
        System.out.println(countOfCharacter);


        //find the average length of students name
        double averageLength = students.stream().mapToInt(String::length).average().orElse(0);
        System.out.println(averageLength);

        //count how many times students name appears in the list

    }
}
