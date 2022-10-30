package cn.myspace.rpc.user.deploy.dto;

import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserLike)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLikeDTO implements Serializable {
    private static final long serialVersionUID = -99353895433073915L;

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
     * 删除标志（0表示点赞，1表示取消）
     */
    private Integer deleteMark;
}