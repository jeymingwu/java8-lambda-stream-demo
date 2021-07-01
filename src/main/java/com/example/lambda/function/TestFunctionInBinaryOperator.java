package com.example.lambda.function;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * @author : jeymingwu
 * @date : 2021-07-01
 **/

public class TestFunctionInBinaryOperator {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> addBiFunction = (x1, x2) -> x1 + x2;
        System.out.println(addBiFunction.apply(2, 4));

        BinaryOperator<Integer> addBinaryFunction = (x1, x2) -> x1 + x2;
        System.out.println(addBinaryFunction.apply(2, 4)); // 与上方一致

        // minBy 的使用方式
        BinaryOperator<Integer> minByBinaryFunction = BinaryOperator.minBy(
                (a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
        System.out.println(minByBinaryFunction.apply(100, 90));

        // maxBy 的使用方式（与 minBy 类似）
        BinaryOperator<Integer> maxByBinaryFunction = BinaryOperator.maxBy(
                (a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
        System.out.println(maxByBinaryFunction.apply(100, 90));
    }
}
