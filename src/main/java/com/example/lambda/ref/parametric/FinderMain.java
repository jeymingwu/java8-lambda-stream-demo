package com.example.lambda.ref.parametric;

import com.example.lambda.ref.IFinder;

/**
 * @author : jeymingwu
 * @date : 2021-06-26
 **/

public class FinderMain {

    public static void main(String[] args) {

        IFinder finder = ((s1, s2) -> s1.indexOf(s2));

        /**
         * 接口 Finder 的 find 方法与 String.indexOf 有着相同的方法签名
         */
        IFinder finder1 = String::indexOf; // 简化

        System.out.println(finder.find("abc", "bc"));

    }
}
