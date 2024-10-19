package com.xiaohan.demo.design.pattern.template.menu;


import com.xiaohan.demo.design.pattern.template.CookTemplate;

public class KungPaoChicken extends CookTemplate {

    protected void prepareMaterials() {
        System.out.println("prepare chicken and pickled cucumber and carrot");
    }

    protected void cooking() {
        System.out.println("cooking KungPaoChicken");
    }

    protected void plating() {
        System.out.println("pour in a plate");
    }
}
