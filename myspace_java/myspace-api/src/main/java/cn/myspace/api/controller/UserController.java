package cn.myspace.api.controller;

/**
 */

import cn.myspace.api.util.AddressUtils;
import cn.myspace.api.util.IpUtils;
import cn.myspace.api.util.Md5Utils;
import cn.myspace.api.util.ServletUtils;
import cn.myspace.common.PageResult;
import cn.myspace.common.Result;
import cn.myspace.rpc.user.deploy.IUserDeploy;
import cn.myspace.rpc.user.deploy.dto.UserDTO;
import cn.myspace.rpc.user.deploy.dto.UserLoginDTO;
import cn.myspace.rpc.user.deploy.req.UserLoginReq;
import cn.myspace.rpc.user.deploy.req.UserPageReq;
import cn.myspace.rpc.user.deploy.req.UserReq;
import eu.bitwalker.useragentutils.UserAgent;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @DubboReference
    private IUserDeploy userDeploy;

    @GetMapping("/list/page")
    public PageResult getUserListByPage(@RequestBody UserPageReq req) {
        PageResult result = userDeploy.getUserListByPage(req);
        logger.info("测试结果：{}", result); // ArrayUtil.toString(((List<UserDTO>) result.get(Result.DATA_TAG)).toArray())
        return result;
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserReq req) {
        UserDTO userDTO = req.getUser();
        userDTO.setPassword(Md5Utils.hash(userDTO.getPassword()));
        return userDeploy.addUser(req);
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserReq req) {
        UserDTO userDTO = req.getUser();
        userDTO.setPassword(Md5Utils.hash(userDTO.getPassword()));
        UserLoginDTO userLoginDTO = UserLoginDTO.builder()
                .user(userDTO)
                .build();
        setUserAgent(userLoginDTO);
        UserLoginReq userLoginReq = UserLoginReq.builder()
                .userLogin(userLoginDTO)
                .build();
        return userDeploy.login(userLoginReq);
    }

    @PostMapping("/logout")
    public Result logout(@RequestBody UserLoginReq req) {
        return userDeploy.logout(req);
    }

    /**
     * 设置用户代理信息
     */
    public void setUserAgent(UserLoginDTO userLoginDTO)
    {
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        userLoginDTO.setIpaddr(ip);
        userLoginDTO.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
        userLoginDTO.setBrowser(userAgent.getBrowser().getName());
        userLoginDTO.setOs(userAgent.getOperatingSystem().getName());
    }

}
