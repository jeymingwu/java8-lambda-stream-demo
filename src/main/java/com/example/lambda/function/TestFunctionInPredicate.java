package com.example.lambda.function;

import java.util.function.Predicate;

/**
 * @author : jeymingwu
 * @date : 2021-07-01
 **/

public class TestFunctionInPredicate {

    public static void main(String[] args) {

        Predicate<String> stringLengthPredicate = s -> s.length() > 4;
        System.out.println(stringLengthPredicate.test("hello"));
        System.out.println(stringLengthPredicate.test("hi"));

        // 匿名内部类的实现方式，效果与上面一致
        Predicate<String> stringLengthOtherPredicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 4;
            }
        };
        System.out.println(stringLengthOtherPredicate.test("hello"));
        System.out.println(stringLengthOtherPredicate.test("hi"));

        // 三种逻辑关系 —— 与或非的默认方式的使用
        Predicate<String> stringLengthPredicateII = s -> s.length() < 6;
        System.out.println(stringLengthPredicate.and(stringLengthPredicateII).test("hello"));
        System.out.println(stringLengthPredicate.and(stringLengthPredicateII).test("chinese"));

        Predicate<String> stringContainsPredicate = s -> s.contains("h");
        System.out.println(stringLengthPredicate.or(stringContainsPredicate).test("hello"));
        System.out.println(stringLengthPredicate.or(stringContainsPredicate).test("hi"));
        System.out.println(stringLengthPredicate.or(stringContainsPredicate).test("bye"));

        System.out.println(stringLengthPredicate.negate().test("hello"));
        System.out.println(stringLengthPredicate.negate().test("hi"));

        // isEqual 默认方法的使用
        System.out.println(Predicate.isEqual("hello").test("hello"));
        System.out.println(Predicate.isEqual("hello").test("hi"));

        Predicate<String> stringEqualPredicate = Predicate.isEqual("hello");
        System.out.println(stringLengthPredicate.and(stringEqualPredicate).test("hello"));
        System.out.println(stringLengthPredicate.and(stringEqualPredicate).test("hi"));
    }
}
