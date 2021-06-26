package com.example.lambda.ref.constructor;

/**
 * @author : jeymingwu
 * @date : 2021-06-26
 **/

public class ConstructorMain {

    public static void main(String[] args) {

        /**
         * MyFactory 接口定义 create 方法，接收一个 char[] 类型的输入参数，返回值类型为 String, 它与 String(char[] chars) 这个 String 的构造函数有着相同的方法签名
         */
        IMyFactory myFactory = String::new;

        IMyFactory myFactory2 = chars -> new String(chars);
    }
}
