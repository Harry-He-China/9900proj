package cn.myspace.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (UserCoins)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCoins implements Serializable {
    private static final long serialVersionUID = -53262163082529539L;

    private Long userId;

    private User contributor;

    private Long donorId;

    private User donor;

    private Long manuscriptId;

    private Manuscript manuscript;

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