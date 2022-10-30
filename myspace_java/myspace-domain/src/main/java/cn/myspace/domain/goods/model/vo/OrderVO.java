package cn.myspace.domain.goods.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * (Order)值对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderVO implements Serializable {
    private static final long serialVersionUID = 653184919284164544L;

    private Long orderId;

    private Long goodsId;

    private GoodsVO goods;

    private Integer num;

    private BigDecimal totalPrice;

    /* 用于价格范围搜索 */
    private Double minPrice;
    private Double maxPrice;

    /**
     * 创建者
     */
    private Long creator;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志
     */
    private Integer deleteMark;
}