package com.example.lambda.staticref;

import com.example.lambda.ref.IFinder;

/**
 * @author : jeymingwu
 * @date : 2021-06-26
 **/

public class FinderMain {

    public static void main(String[] args) {

        /**
         * IFinder 接口中 find 方法和 StaticFinder 中的 doFind 方法有相同的输入参数（参数个数与类型完全相同），
         * 又因 doFind 是静态方法，可使用静态方法引用；
         */
        IFinder finder = com.example.lambda.staticref.StaticFinder::doFind;
        System.out.println(finder.find("123456", "456"));

    }
}
