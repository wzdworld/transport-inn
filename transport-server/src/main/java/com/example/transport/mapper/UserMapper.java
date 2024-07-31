package com.example.transport.mapper;

import com.example.transport.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 根据手机号查询用户
     *
     * @param phone
     * @return
     */
    User getByPhone(String phone);

}