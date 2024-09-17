package com.xiaohan.demo.spring.mvc.dao.mapper;

import com.xiaohan.demo.spring.mvc.dao.entity.OrderEntity;
import com.xiaohan.demo.spring.mvc.model.param.OrderQueryParam;
import com.xiaohan.demo.spring.mvc.util.IdUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class OrderMapperTest {

    @Resource
    private OrderMapper orderMapper;

    @Transactional
    @Test
    public void testInsert() {
        OrderEntity orderEntity = createOrderEntity();
        int insert = orderMapper.insert(orderEntity);
        AssertionErrors.assertTrue("Insert Fail", insert > 0);
    }

    @Transactional
    @Test
    public void testSelectOne() {
        OrderEntity orderEntity = createOrderEntity();
        int insert = orderMapper.insert(orderEntity);
        AssertionErrors.assertTrue("Insert Fail", insert > 0);

        String orderId = orderEntity.getOrderId();
        OrderEntity order = orderMapper.selectOneByOrderId(orderId);
        AssertionErrors.assertEquals("Select Fail", order.getOrderId(), orderEntity.getId());
    }

    @Transactional
    @Test
    public void testUpdate(){
        OrderEntity orderEntity = createOrderEntity();
        int insert = orderMapper.insert(orderEntity);
        AssertionErrors.assertTrue("Insert Fail", insert > 0);

        String updatedExt = "update test";
        orderEntity.setExt(updatedExt);
        int update = orderMapper.update(orderEntity);
        AssertionErrors.assertTrue("Update Fail", update > 0);

        OrderEntity updatedOrder = orderMapper.selectOneByOrderId(orderEntity.getOrderId());
        AssertionErrors.assertNotNull("Select Fail", updatedOrder);
        AssertionErrors.assertEquals("Update Ext Fail", updatedOrder.getExt(), updatedExt);
    }

    @Transactional
    @Test
    public void testSelectListByCondition() {
        OrderEntity orderEntity = createOrderEntity();
        int insert = orderMapper.insert(orderEntity);
        AssertionErrors.assertTrue("Insert Fail", insert > 0);

        OrderQueryParam queryParam = new OrderQueryParam();
        queryParam.setOrderIdList(List.of(orderEntity.getOrderId()));
        List<OrderEntity> orderEntities = orderMapper.selectListByCondition(queryParam);
        AssertionErrors.assertNotNull("Select Fail", orderEntities);
        AssertionErrors.assertEquals("Select Condition Fail", 1, orderEntities.size());
        OrderEntity order = orderEntities.get(0);
        AssertionErrors.assertEquals("Equals Fail",  orderEntity.getOrderId(), order.getOrderId());
    }


    private OrderEntity createOrderEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(IdUtils.UUID());
        orderEntity.setUserId(IdUtils.UUID());
        orderEntity.setChannel("paypal");
        orderEntity.setAmount(7711L);
        orderEntity.setCurrencyCode("CNY");
        orderEntity.setStatus(1);
        orderEntity.setRemarks("test");
        orderEntity.setCreatedAt(LocalDateTime.now());
        orderEntity.setUpdatedAt(LocalDateTime.now());
        return orderEntity;
    }
}
