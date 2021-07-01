package com.example.lambda.function;

import java.util.function.UnaryOperator;

/**
 * @author : jeymingwu
 * @date : 2021-07-01
 **/

public class TestFunctionInUnaryOperator {

    public static void main(String[] args) {

        UnaryOperator<Integer> operator = t -> t * 2;

        System.out.println(operator.apply(2));
        System.out.println(operator.apply(4));

        UnaryOperator<Integer> add5Operator = t -> t + 5;
        UnaryOperator<Integer> mul2Operator = t -> t * 2;
        System.out.println(add5Operator.compose(mul2Operator).apply(2));
        System.out.println(add5Operator.andThen(mul2Operator).apply(2));
    }
}
