package cn.myspace.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserCollection)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCollection implements Serializable {
    private static final long serialVersionUID = -47567658373166774L;

    private Long userId;

    private Long donorId;

    private User donor;

    private Long manuscriptId;

    private Manuscript manuscript;
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