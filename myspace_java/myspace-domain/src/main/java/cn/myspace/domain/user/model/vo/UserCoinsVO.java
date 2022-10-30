package cn.myspace.domain.user.model.vo;

import cn.myspace.domain.manuscript.model.vo.ManuscriptVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (UserCoins)值对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCoinsVO implements Serializable {
    private static final long serialVersionUID = -53262163082529539L;

    private Long userId;

    private UserVO contributor;

    private Long donorId;

    private UserVO donor;

    private Long manuscriptId;

    private ManuscriptVO manuscript;

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