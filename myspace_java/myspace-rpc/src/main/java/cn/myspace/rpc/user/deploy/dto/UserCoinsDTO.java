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
 * (UserCoins)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCoinsDTO implements Serializable {
    private static final long serialVersionUID = -53262163082529539L;

    private Long userId;

    private UserDTO contributor;

    private Long donorId;

    private UserDTO donor;

    private Long manuscriptId;

    private ManuscriptDTO manuscript;

    private BigDecimal coins;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志（0表示完成投币，1表示退回）
     */
    private Integer deleteMark;

}