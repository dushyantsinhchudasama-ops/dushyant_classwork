package com.tss.test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);

        System.out.println(numbers);

        numbers.add(2,40);
        System.out.println(numbers);

        System.out.println("Element on first index: " + (numbers.get(1)));

        System.out.println("D0 List contains 50: " + numbers.contains(50));

        System.out.println("Hashcode: " + numbers.hashCode());

        System.out.println("Size of list is: " + numbers.size());


    }
}
