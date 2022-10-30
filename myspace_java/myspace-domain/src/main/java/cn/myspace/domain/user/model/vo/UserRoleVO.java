package cn.myspace.domain.user.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserRole)值对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleVO implements Serializable {

    private Long userId;

    private Integer roleId;

    private RoleVO role;

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
