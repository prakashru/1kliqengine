package com.emuntiy.rest.webservice.functionalprogramming;

import java.util.List;

public class functionexampleone {

    private  static void print(int number){
        System.out.println(number);
    }

    public static void main(String[] args) {
        System.out.println("Functional programming example one");

        printAllNumberInFunctionalApproach(List.of(12,3,4,23,232,32,3));


        System.out.println("---Print all even---");
        printAllEvenNumberInFunctionalApproach(List.of(12,3,4,23,232,32,3));
    }

    private static boolean isEven(int n){
        return n%2==0;
    }

    private static void printAllEvenNumberInFunctionalApproach(List<Integer> integers) {

        integers.stream().filter(functionexampleone::isEven).forEach(System.out::println);

        integers.stream().filter(n->n%2==0).forEach(System.out::println);
    }

    private static void printAllNumberInFunctionalApproach(List<Integer> numbers) {
        numbers.stream().forEach(n->print(n));

        System.out.println("----------------");
        numbers.stream().forEach(functionexampleone::print);   //:: method reference

        System.out.println("----------------");
        System.out.println("----------------");
        numbers.stream().forEach(System.out::println);   //:: method reference
    }
}
