package com.example.lambda.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author : jeymingwu
 * @date : 2021-07-01
 **/

public class TestFunctionInConsumer {

    public static void main(String[] args) {

        Consumer<String> stringDisplay = System.out::println;
        stringDisplay.accept("hello world!");

        Consumer<List<Integer>> listModify = list -> {
            for (int i = 0; i < list.size(); ++i) {
                list.set(i, list.get(i) * 2);
            }
        };

        Consumer<List<Integer>> listDisplay = list -> list.forEach(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        listModify.accept(list);
        listDisplay.accept(list);

        // andThen 的使用
        listModify.andThen(listDisplay).accept(list);
    }
}
