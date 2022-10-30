package cn.myspace.rpc.user.deploy.dto;

import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserCollection)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCollectionDTO implements Serializable {
    private static final long serialVersionUID = -47567658373166774L;

    private Long userId;

    private Long donorId;

    private UserDTO donor;

    private Long manuscriptId;

    private ManuscriptDTO manuscript;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志（0表示收藏，1表示取消收藏）
     */
    private Integer deleteMark;

}