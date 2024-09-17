package com.xiaohan.demo.basic.threadlocal;


import java.util.concurrent.TimeUnit;

public class UserService {

    public void doSomething(String userId){
        // do user service
        try {
            System.out.println(userId + " Done : " + UserContextUtil.getUserInfo());
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
