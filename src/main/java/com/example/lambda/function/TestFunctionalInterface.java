package com.example.lambda.function;

/**
 * @author : jeymingwu
 * @date : 2021-06-26
 **/

@FunctionalInterface
public interface TestFunctionalInterface {

    void doTest(); // 抽象方法

    boolean equals(Object object); // java.lang.Object 中的 public 方法
    String toString(); // java.lang.Object 中的 public 方法

    public default void doDefaultMethod() {
        System.out.println("call do-defaultMethod");
    }

    public static void doStaticMethod() {
        System.out.println("call do-staticMethod");
    }

    public static void main(String[] args) {

        // 实现抽象方法
        TestFunctionalInterface test = () -> {
            System.out.println("call do-Test");
        };

        // 执行抽象方法
        test.doTest();

        // 执行默认方法
        test.doDefaultMethod();

        // 执行 toString 方法
        System.out.println(test.toString());

        // 执行静态方法
        TestFunctionalInterface.doStaticMethod();
    }
}
