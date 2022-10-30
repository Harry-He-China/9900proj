package cn.myspace.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * (Goods)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods implements Serializable {
    private static final long serialVersionUID = -61354672389802280L;

    private Long goodsId;
    /**
     * 商品名
     */
    private String name;
    /**
     * 商品图片
     */
    private String pic;
    /**
     * 商品标签
     */
    private String tag;
    /**
     * 商品简介
     */
    private String intro;
    /**
     * 商品价格
     */
    private BigDecimal price;

    /* 用于价格范围搜索 */
    private Double minPrice;
    private Double maxPrice;

    /**
     * 商品描述
     */
    private Object info;
    /**
     * 商品评论列表
     */
    private List<GoodsComment> goodsComments;
    /**
     * 关联帖子列表
     */
    private List<Manuscript> manuscripts;
    /**
     * 创建者
     */
    private Long creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /* 用于时间范围搜索 */
    private Date startTime;
    private Date endTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志
     */
    private Integer deleteMark;
}