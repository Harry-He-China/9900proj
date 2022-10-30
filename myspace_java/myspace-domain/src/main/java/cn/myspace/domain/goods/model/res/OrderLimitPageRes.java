package cn.myspace.domain.goods.model.res;

import cn.myspace.domain.goods.model.vo.OrderVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 订单分页查询聚合对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLimitPageRes {

    private Long count;

    private List<OrderVO> orderVOList;
}
