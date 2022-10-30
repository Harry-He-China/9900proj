package cn.myspace.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserLike)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLike implements Serializable {
    private static final long serialVersionUID = -99353895433073915L;

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
     * 删除标志（0表示点赞，1表示取消）
     */
    private Integer deleteMark;
}