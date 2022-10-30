package cn.myspace.rpc.user.deploy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserFollow)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFollowDTO implements Serializable {
    private static final long serialVersionUID = 497776319964848968L;

    private Long userId;

    private UserDTO fun;

    private Long followerId;

    private UserDTO follower;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志（0表示关注，1表示取关）
     */
    private Integer deleteMark;
}