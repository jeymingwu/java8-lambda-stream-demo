package com.example.lambda.function;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Function;

/**
 * @author : jeymingwu
 * @date : 2021-07-01
 **/

public class TestFunctionInFunction {

    public static void main(String[] args) {

        // V,R -> IN,OUT
        Function<String, Integer> stringLengthFunction = s -> s.length();
        System.out.println(stringLengthFunction.apply("hello"));

        Function<String, String> stringToUpperCaseFunction = s -> s.toUpperCase();
        Function<String, String> stringToLowerCaseFunction = s -> s.toLowerCase();
        Function<String, String[]> stringSplitFunction = s -> s.split(" ");

        // compose 的使用（先执行参数，再执行调用者）（andThen 刚好与之相反）
        System.out.println(stringToUpperCaseFunction.compose(stringToLowerCaseFunction).apply("HELLO world!"));
        System.out.println(stringToUpperCaseFunction.andThen(stringToLowerCaseFunction).apply("HELLO world!"));

        // andThen 的使用注意参数输入和输出的类型（先执行调用者，再执行参数）
        String[] strings = stringToUpperCaseFunction.andThen(stringSplitFunction).apply("Hello world!");
        System.out.println(Arrays.toString(strings));
    }
}
