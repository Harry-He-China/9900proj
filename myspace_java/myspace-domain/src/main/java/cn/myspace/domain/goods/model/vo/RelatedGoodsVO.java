package cn.myspace.domain.goods.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (RelatedGoods)值对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RelatedGoodsVO implements Serializable {
    private static final long serialVersionUID = -64345774458588502L;

    private Long manuscriptId;

    private Long goodsId;
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