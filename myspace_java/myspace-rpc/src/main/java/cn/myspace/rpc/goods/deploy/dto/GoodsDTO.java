package cn.myspace.rpc.goods.deploy.dto;

import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptCommentDTO;
import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * (Goods)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsDTO implements Serializable {
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
    private List<GoodsCommentDTO> goodsComments;
    /**
     * 帖子评论列表
     */
    private List<ManuscriptCommentDTO> manuscriptComments;
    /**
     * 关联帖子列表
     */
    private List<ManuscriptDTO> manuscripts;
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