package com.snippet.springtransaction.utils;

import cn.hutool.core.util.IdUtil;
import com.snippet.springtransaction.dao.entity.Order;
import com.snippet.springtransaction.dao.entity.User;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * create by whr on 2023-05-26
 */
public class Tools {

    public static User createUser() {
        User user = new User();
        user.setId(IdUtil.getSnowflakeNextId());
        user.setUsername(generateUsername());
        user.setPassword("123456");
        user.setStatus(new Random().nextInt(2));
        user.setPhone(generatePhone());
        user.setCreatedAt(LocalDateTime.now().plusDays(new Random().nextInt(201) - 100));
        user.setEmail(generateEmail());
        user.setType(new Random().nextInt(2));
        return user;
    }

    private static String generateUsername() {
        Random random = new Random();
        int nameLength = random.nextInt(10 - 5 + 1) + 5;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nameLength; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }

        return sb.toString();
    }

    private static String generatePhone() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("1"); // 手机号第一位固定为1
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10)); // 后续10位随机生成数字
        }
        return sb.toString();
    }

    private static String generateEmail() {
        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        sb.append("user").append(random.nextInt(1000)); // 生成长度为4的用户名
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"}; // 邮箱域名列表
        String domain = domains[random.nextInt(domains.length)]; // 随机选取一个域名

        return sb + "@" + domain;
    }

    public static Order createOrder(User user) {
        Order order = new Order();
        order.setUserId(user.getId());
        order.setId(IdUtil.getSnowflakeNextId());
        order.setCreatedAt(LocalDateTime.now());
        return order;
    }
}
