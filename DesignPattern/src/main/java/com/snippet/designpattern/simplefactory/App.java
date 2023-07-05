package com.snippet.designpattern.simplefactory;

/**
 * create by whr on 2023-07-05
 */
public class App {
    public static void main(String[] args) {
        Clothes clothes = ClothesFactory.create(ClothesTypeEnum.COAT);
        System.out.println(clothes.getType());
    }
}
