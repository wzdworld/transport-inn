package com.example.transport.service;

import com.example.transport.dto.UserDTO;
import com.example.transport.dto.UserLoginDTO;
import com.example.transport.entity.User;

public interface UserService {

    /**
     * 用户登录
     *
     * @param userLoginDTO
     * @return
     */
    User login(UserLoginDTO userLoginDTO);

    /**
     * 用户注册
     *
     * @param userDTO
     */
    void register(UserDTO userDTO,int type);
}