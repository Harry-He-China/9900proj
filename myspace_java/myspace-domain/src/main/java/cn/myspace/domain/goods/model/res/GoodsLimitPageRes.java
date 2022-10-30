package cn.myspace.domain.goods.model.res;

import cn.myspace.domain.goods.model.vo.GoodsVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 商品分页查询聚合对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsLimitPageRes {

    private Long count;

    private List<GoodsVO> goodsVOList;
}
