package com.xiaohan.demo.design.pattern.simplefactory;

import com.snippet.designpattern.simplefactory.clothes.Coat;
import com.snippet.designpattern.simplefactory.clothes.Jeans;

import java.util.HashMap;
import java.util.Map;

/**
 * create by whr on 2023-07-05
 */
public class ClothesFactory {

    private static final Map<ClothesTypeEnum, Clothes> clothesMap = new HashMap<>();

    static {
        clothesMap.put(ClothesTypeEnum.JEANS, new Jeans());
        clothesMap.put(ClothesTypeEnum.COAT, new Coat());
    }

    public static Clothes create(ClothesTypeEnum clothesTypeEnum) {
        return clothesMap.get(clothesTypeEnum);
    }
}
