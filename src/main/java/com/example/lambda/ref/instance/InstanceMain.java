package com.example.lambda.ref.instance;

/**
 * @author : jeymingwu
 * @date : 2021-06-26
 **/

public class InstanceMain {

    public static void main(String[] args) {

        /**
         * Serializer.serialize 方法和 StringConvertor.converToInt 有着相同的方法签名；
         * 可以创建一个 StringConvertor 的实例，并通过 Lambda 表达式将其并引用给 convertToInt() 方法
         */
        StringConverter stringConverter = new StringConverter();
        ISerializer serializer = stringConverter::convertToInt;

        System.out.println(serializer.serialize("100"));
    }
}
