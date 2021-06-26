package com.example.lambda.function;

/**
 * @author : jeymingwu
 * @date : 2021-06-26
 **/

public class TestLambdaAndInnerClass {

    public void test() {

        Runnable innerRunnable = new Runnable() {

            @Override
            public void run() {
                System.out.println("call run in innerRunnable:\t" + this.getClass());
            }
        };

        Runnable lambdaRunnable = () -> System.out.println("call run in lambdaRunnable:\t" + this.getClass());

        new Thread(innerRunnable).start();
        new Thread(lambdaRunnable).start();
    }

    public static void main(String[] args) {
        new TestLambdaAndInnerClass().test();
    }
}
