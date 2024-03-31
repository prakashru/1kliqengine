package com.emuntiy.rest.webservice.functionalprogramming;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlyaingWithOptionalFeatures {
    public static void main(String[] args) {
        List<String> fruits= List.of("banana","mango", "orange");
        Predicate<? super String> predicate=fruit->fruit.startsWith("p");
        Optional<String> optional=fruits.stream().filter(predicate).findFirst();
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        Optional<String> fruit= Optional.of("banana");
        Optional<String> emptyvalue = Optional.empty();


    }
}
