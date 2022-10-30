package cn.myspace.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (UserRole)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRole {

    private Long userId;

    private Integer roleId;

    private Role role;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志（0代表启用，1代表删除）
     */
    private Integer deleteMark;
}
