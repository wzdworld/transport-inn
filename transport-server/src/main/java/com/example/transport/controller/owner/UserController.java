package com.example.transport.controller.owner;

import com.example.transport.constant.JwtClaimsConstant;
import com.example.transport.dto.UserLoginDTO;
import com.example.transport.entity.User;
import com.example.transport.properties.JwtProperties;
import com.example.transport.result.Result;
import com.example.transport.service.UserService;
import com.example.transport.utils.JwtUtil;
import com.example.transport.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 货主管理
 */
@RestController(value = "ownerUserController")
@RequestMapping("/owner/user")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "货主接口")
public class UserController {
    private final UserService userService;
    private final JwtProperties jwtProperties;

    /**
     * 货主登录
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "货主登录")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("货主登录：{}", userLoginDTO);

        User user = userService.login(userLoginDTO);

        // 账号验证成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());

        // 动态加载
        String token = JwtUtil.createJWT(
                jwtProperties.getOwnerSecretKey(),
                jwtProperties.getOwnerTtl(),
                claims);

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .name(user.getName())
                .token(token)
                .build();
        return Result.success(userLoginVO);
    }
}