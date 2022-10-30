package cn.myspace.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserDislike)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDislike implements Serializable {
    private static final long serialVersionUID = 193383572852040686L;

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
     * 删除标志（0表示点踩，1表示取消）
     */
    private Integer deleteMark;

}