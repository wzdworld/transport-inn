package com.example.transport.service.impl;

import com.example.transport.constant.MessageConstant;
import com.example.transport.constant.PasswordConstant;
import com.example.transport.dto.UserDTO;
import com.example.transport.dto.UserLoginDTO;
import com.example.transport.entity.User;
import com.example.transport.exception.AccountNotFoundException;
import com.example.transport.exception.PasswordErrorException;
import com.example.transport.mapper.UserMapper;
import com.example.transport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param userLoginDTO
     * @return
     */
    @Override
    public User login(UserLoginDTO userLoginDTO) {
        // 手机号
        String phone = userLoginDTO.getPhone();

        // 密码
        String password = userLoginDTO.getPassword();

        // 根据手机号查询用户
        User user = userMapper.getByPhone(phone);

        // 如果用户不存在，抛出账号不存在异常
        if (user == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        // 密码加密
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        // 如果密码不正确，抛出密码错误异常
        if (!password.equals(user.getPassword())) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        // 返回查询到的对象
        return user;

    }

    /**
     * 用户注册
     *
     * @param userDTO
     */
    @Override
    public void register(UserDTO userDTO, int type) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setType(type);
        user.setCreatedTime(LocalDateTime.now());
        userMapper.save(user);
    }
}