package com.snippet.springtransaction.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snippet.springtransaction.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author haiah
 * @since 2023-03-03 07:42:30
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
