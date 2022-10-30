package cn.myspace.rpc.user.deploy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserLogin)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginDTO implements Serializable {

    private static final long serialVersionUID = -97741324282789749L;
    /**
     * 访问ID
     */
    private Long infoId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户信息
     */
    private UserDTO user;
    /**
     * 登录IP地址
     */
    private String ipaddr;
    /**
     * 登录地点
     */
    private String loginLocation;
    /**
     * 浏览器类型
     */
    private String browser;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 登录状态（-1失败 0登录 1退出）
     */
    private Integer status;
    /**
     * 提示消息
     */
    private String msg;
    /**
     * 访问时间
     */
    private Date loginTime;
    /**
     * 用户唯一标识
     */
    private String token;
    /**
     * 过期时间
     */
    private Long expireTime;

}
