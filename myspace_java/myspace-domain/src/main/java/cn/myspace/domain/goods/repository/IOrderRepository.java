package cn.myspace.domain.goods.repository;

import cn.myspace.domain.goods.model.req.OrderLimitPageReq;
import cn.myspace.domain.goods.model.res.OrderLimitPageRes;
import cn.myspace.domain.goods.model.vo.OrderVO;

/**
 * 订单资源库
 */
public interface IOrderRepository {

    /* OrderVO */

    OrderLimitPageRes queryOrderLimitPage(OrderLimitPageReq req);

    OrderVO queryOrderById(Long orderId);

    int insertOrder(OrderVO orderVO);

    int updateOrder(OrderVO orderVO);

    int deleteOrder(OrderVO orderVO);
}
