package cn.myspace.rpc.user.deploy.dto;

import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserDislike)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDislikeDTO implements Serializable {
    private static final long serialVersionUID = 193383572852040686L;

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
     * 删除标志（0表示点踩，1表示取消）
     */
    private Integer deleteMark;

}