package com.example.lambda.function;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author : jeymingwu
 * @date : 2021-07-01
 **/

public class TestFunctionInSupplier {

    public static void main(String[] args) {

        Supplier<String> string = () -> "hello world!";
        System.out.println(string.get());

        class Goods {
            String name = "pen";

            public Goods() {
            }

            public Goods(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Goods)) return false;

                Goods goods = (Goods) o;

                return getName().equals(goods.getName());
            }

            @Override
            public int hashCode() {
                return getName().hashCode();
            }
        }

        Supplier<Goods> goodsSupplier = Goods::new;
        System.out.println(goodsSupplier.get().getName());

        Goods goods = goodsSupplier.get();
        Goods otherGoods = goodsSupplier.get();
        System.out.println(goods == otherGoods);
        System.out.println(goods.equals(otherGoods));
        System.out.println(goods.hashCode());
        System.out.println(otherGoods.hashCode());
    }
}
