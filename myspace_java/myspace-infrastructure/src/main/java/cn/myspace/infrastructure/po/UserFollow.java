package cn.myspace.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserFollow)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFollow implements Serializable {
    private static final long serialVersionUID = 497776319964848968L;

    private Long userId;

    private User fun;

    private Long followerId;

    private User follower;
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