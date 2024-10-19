package com.xiaohan.demo.spring.mvc.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 批量插入需要对参数判空判null
 * <p>
 * create by whr on 2023/2/19
 */
public interface BatchBaseMapper<T> extends BaseMapper<T> {

    void insertBatchSomeColumn(List<T> entityList);
}
