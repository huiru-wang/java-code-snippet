package com.xiaohan.demo.spring.mvc.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaohan.demo.spring.mvc.dao.entity.UserEntity;
import com.xiaohan.demo.spring.mvc.model.param.QueryParam;
import com.xiaohan.demo.spring.mvc.util.IdUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.util.AssertionErrors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Transactional(rollbackFor = Exception.class) // 测试下默认自动回滚
 * create by whr on 2023/2/15
 */
@SpringBootTest
public class UserEntityMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    @Rollback(value = false)
    public void testInsertBatchSomeColumn() {
        long startTime = System.nanoTime();
        List<UserEntity> userEntities = createUsers();
        userMapper.insertBatchSomeColumn(userEntities);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime); // 6_662_785_700  6s
    }

    @Test
    public void testSelectUserList() {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.le(UserEntity::getId, 1627314511772188795L);
        List<UserEntity> res = userMapper.selectList(queryWrapper);
        System.out.println(res.size());
    }

    @Test
    public void testSelectByCondition() {
        List<UserEntity> userEntities = createUsers();
        userMapper.insertBatchSomeColumn(userEntities);
        UserEntity userEntity = userEntities.get(0);

        QueryParam queryParam = new QueryParam();
        queryParam.setUserIdList(List.of(userEntity.getUserId()));
        queryParam.setUserName(userEntity.getUsername());
        queryParam.setPhoneNoList(List.of(userEntity.getPhone()));

        List<UserEntity> userEntitieList = userMapper.selectByCondition(queryParam);
        userEntitieList.forEach(item -> {
            AssertionErrors.assertEquals("Select Failed", item.getUsername(), userEntity.getUsername());
            AssertionErrors.assertEquals("Select Failed", item.getUserId(), userEntity.getUserId());
            AssertionErrors.assertEquals("Select Failed", item.getPhone(), userEntity.getPhone());
        });
    }

    @Test
    public void testSelectPage() {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.le(UserEntity::getId, 1627314511772188795L);
        Page<UserEntity> page = new Page<>(1, 100);
        Page<UserEntity> res = userMapper.selectPage(page, queryWrapper);
        System.out.println(res.getTotal());  // 总数
        System.out.println(res.getPages()); // 总页
        System.out.println(res.getCurrent());   // 当前页
        System.out.println(res.getSize());  // 当前页记录数
        List<UserEntity> records = res.getRecords();
        System.out.println(records.size()); // 100
    }

    @Test
    @Rollback(value = false)
    public void testDeleteData() {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.ge(UserEntity::getCreatedAt, "2023-04-30 00:00:50").le(UserEntity::getCreatedAt, "2023-04-30 23:59:50");
        userMapper.delete(queryWrapper);
    }

    public List<UserEntity> createUsers() {
        List<UserEntity> userEntities = new ArrayList<>();
        for (int i = 0; i < 5_000; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(IdUtils.UUID());
            userEntity.setUsername(generateUsername());
            userEntity.setPassword("123456");
            userEntity.setStatus(new Random().nextInt(2));
            userEntity.setPhone(generatePhone());
            userEntity.setCreatedAt(LocalDateTime.now().plusDays(new Random().nextInt(201) - 100));
            userEntity.setUpdatedAt(LocalDateTime.now());
            userEntities.add(userEntity);
        }
        return userEntities;
    }

    private String generateUsername() {
        Random random = new Random();
        int nameLength = random.nextInt(10 - 5 + 1) + 5;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nameLength; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }

        return sb.toString();
    }

    private String generatePhone() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("1"); // 手机号第一位固定为1
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10)); // 后续10位随机生成数字
        }
        return sb.toString();
    }

    private String generateEmail() {
        Random random = new Random();

        String sb = "user" + random.nextInt(1000); // 生成长度为4的用户名
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"}; // 邮箱域名列表
        String domain = domains[random.nextInt(domains.length)]; // 随机选取一个域名

        return sb + "@" + domain;
    }
}