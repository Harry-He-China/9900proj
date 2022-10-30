package cn.myspace.domain.user.model.vo;

import cn.myspace.domain.manuscript.model.vo.ManuscriptVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserLike)值对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLikeVO implements Serializable {
    private static final long serialVersionUID = -99353895433073915L;

    private Long userId;

    private Long donorId;

    private UserVO donor;

    private Long manuscriptId;

    private ManuscriptVO manuscript;
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