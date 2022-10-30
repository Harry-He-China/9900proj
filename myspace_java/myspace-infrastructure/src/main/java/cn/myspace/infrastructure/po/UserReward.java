package cn.myspace.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (UserReward)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReward implements Serializable {
    private static final long serialVersionUID = 318729645340193224L;

    private Long userId;

    private User contributor;

    private Long donorId;

    private User donor;

    private Long manuscriptId;

    private Manuscript manuscript;

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