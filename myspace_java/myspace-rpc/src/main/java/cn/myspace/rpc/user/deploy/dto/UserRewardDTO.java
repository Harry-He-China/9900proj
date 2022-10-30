package cn.myspace.rpc.user.deploy.dto;

import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (UserReward)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRewardDTO implements Serializable {
    private static final long serialVersionUID = 318729645340193224L;

    private Long userId;

    private UserDTO contributor;

    private Long donorId;

    private UserDTO donor;

    private Long manuscriptId;

    private ManuscriptDTO manuscript;

    private BigDecimal reward;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志（0表示完成捐赠，1表示退回）
     */
    private Integer deleteMark;

}