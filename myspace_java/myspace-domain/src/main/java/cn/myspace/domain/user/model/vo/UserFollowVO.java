package cn.myspace.domain.user.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserFollow)值对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFollowVO implements Serializable {
    private static final long serialVersionUID = 497776319964848968L;

    private Long userId;

    private UserVO fun;

    private Long followerId;

    private UserVO follower;
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