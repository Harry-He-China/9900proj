package cn.myspace.rpc.user.deploy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * (UserRole)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleDTO {

    private Long userId;

    private Integer roleId;

    private RoleDTO role;

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
