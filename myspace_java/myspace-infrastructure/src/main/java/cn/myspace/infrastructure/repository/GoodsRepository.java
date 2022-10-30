package cn.myspace.infrastructure.repository;

import cn.myspace.domain.goods.model.req.GoodsLimitPageReq;
import cn.myspace.domain.goods.model.req.OrderLimitPageReq;
import cn.myspace.domain.goods.model.res.GoodsLimitPageRes;
import cn.myspace.domain.goods.model.res.OrderLimitPageRes;
import cn.myspace.domain.goods.model.vo.GoodsCommentVO;
import cn.myspace.domain.goods.model.vo.GoodsVO;
import cn.myspace.domain.goods.model.vo.OrderVO;
import cn.myspace.domain.goods.model.vo.RelatedGoodsVO;
import cn.myspace.domain.goods.repository.IGoodsRepository;
import cn.myspace.domain.goods.repository.IOrderRepository;
import cn.myspace.infrastructure.dao.IGoodsCommentDao;
import cn.myspace.infrastructure.dao.IGoodsDao;
import cn.myspace.infrastructure.dao.IOrderDao;
import cn.myspace.infrastructure.dao.IRelatedGoodsDao;
import cn.myspace.infrastructure.po.Goods;
import cn.myspace.infrastructure.po.GoodsComment;
import cn.myspace.infrastructure.po.Order;
import cn.myspace.infrastructure.po.RelatedGoods;
import cn.myspace.infrastructure.util.RedisUtil;
import cn.myspace.infrastructure.util.converter.GoodsCommentVOMapping;
import cn.myspace.infrastructure.util.converter.GoodsVOMapping;
import cn.myspace.infrastructure.util.converter.OrderVOMapping;
import cn.myspace.infrastructure.util.converter.RelatedGoodsVOMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品、订单资源库实现
 */
@Repository
public class GoodsRepository implements IGoodsRepository, IOrderRepository {

    private Logger logger = LoggerFactory.getLogger(GoodsRepository.class);

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private IGoodsDao goodsDao;

    @Resource
    private IGoodsCommentDao goodsCommentDao;

    @Resource
    private IRelatedGoodsDao relatedGoodsDao;

    @Resource
    private IOrderDao orderDao;

    @Override
    public GoodsLimitPageRes queryGoodsLimitPage(GoodsLimitPageReq req) {
        Long count = goodsDao.queryCount(req);
        List<Goods> goodsList = goodsDao.queryAll(req);
        List<GoodsVO> goodsVOList = GoodsVOMapping.INSTANCE.sourceToTarget(goodsList);
        return new GoodsLimitPageRes(count, goodsVOList);
    }

    @Override
    public GoodsVO queryGoodsById(Long goodsId) {
        Goods goods = goodsDao.queryById(goodsId);
        return GoodsVOMapping.INSTANCE.sourceToTarget(goods);
    }

    @Override
    public GoodsVO queryGoodsByIdWithComment(Long goodsId) {
        Goods goods = goodsDao.queryByIdWithComment(goodsId);
        return GoodsVOMapping.INSTANCE.sourceToTarget(goods);
    }

    @Override
    public GoodsVO queryGoodsByIdWithManuscript(Long goodsId) {
        Goods goods = goodsDao.queryByIdWithManuscript(goodsId);
        return GoodsVOMapping.INSTANCE.sourceToTarget(goods);
    }

    @Override
    public int insertGoods(GoodsVO goodsVO) {
        Goods goods = GoodsVOMapping.INSTANCE.targetToSource(goodsVO);
        return goodsDao.insert(goods);
    }

    @Override
    public int updateGoods(GoodsVO goodsVO) {
        Goods goods = GoodsVOMapping.INSTANCE.targetToSource(goodsVO);
        return goodsDao.update(goods);
    }

    @Override
    public int deleteGoods(GoodsVO goodsVO) {
        Goods goods = GoodsVOMapping.INSTANCE.targetToSource(goodsVO);
        return goodsDao.update(goods);
    }

    @Override
    public GoodsCommentVO queryGoodsCommentByIdWithChildComment(Long commentId) {
        GoodsComment goodsComment = goodsCommentDao.queryByIdWithChildComment(commentId);
        return GoodsCommentVOMapping.INSTANCE.sourceToTarget(goodsComment);
    }

    @Override
    public int insertGoodsComment(GoodsCommentVO goodsCommentVO) {
        GoodsComment goodsComment = GoodsCommentVOMapping.INSTANCE.targetToSource(goodsCommentVO);
        return goodsCommentDao.insert(goodsComment);
    }

    @Override
    public int updateGoodsComment(GoodsCommentVO goodsCommentVO) {
        GoodsComment goodsComment = GoodsCommentVOMapping.INSTANCE.targetToSource(goodsCommentVO);
        return goodsCommentDao.update(goodsComment);
    }

    @Override
    public int deleteGoodsComment(GoodsCommentVO goodsCommentVO) {
        GoodsComment goodsComment = GoodsCommentVOMapping.INSTANCE.targetToSource(goodsCommentVO);
        return goodsCommentDao.update(goodsComment);
    }

    @Override
    public int insertRelatedGoods(RelatedGoodsVO relatedGoodsVO) {
        RelatedGoods relatedGoods = RelatedGoodsVOMapping.INSTANCE.targetToSource(relatedGoodsVO);
        return relatedGoodsDao.insert(relatedGoods);
    }

    @Override
    public int updateRelatedGoods(RelatedGoodsVO relatedGoodsVO) {
        RelatedGoods relatedGoods = RelatedGoodsVOMapping.INSTANCE.targetToSource(relatedGoodsVO);
        return relatedGoodsDao.update(relatedGoods);
    }

    @Override
    public int deleteRelatedGoods(RelatedGoodsVO relatedGoodsVO) {
        RelatedGoods relatedGoods = RelatedGoodsVOMapping.INSTANCE.targetToSource(relatedGoodsVO);
        return relatedGoodsDao.update(relatedGoods);
    }

    @Override
    public OrderLimitPageRes queryOrderLimitPage(OrderLimitPageReq req) {
        Long count = orderDao.queryCount(req);
        List<Order> orderList = orderDao.queryAll(req);
        List<OrderVO> orderVOList = OrderVOMapping.INSTANCE.sourceToTarget(orderList);
        return new OrderLimitPageRes(count, orderVOList);
    }

    @Override
    public OrderVO queryOrderById(Long orderId) {
        Order order = orderDao.queryById(orderId);
        return OrderVOMapping.INSTANCE.sourceToTarget(order);
    }

    @Override
    public int insertOrder(OrderVO orderVO) {
        Order order = OrderVOMapping.INSTANCE.targetToSource(orderVO);
        return orderDao.insert(order);
    }

    @Override
    public int updateOrder(OrderVO orderVO) {
        Order order = OrderVOMapping.INSTANCE.targetToSource(orderVO);
        return orderDao.update(order);
    }

    @Override
    public int deleteOrder(OrderVO orderVO) {
        Order order = OrderVOMapping.INSTANCE.targetToSource(orderVO);
        return orderDao.update(order);
    }
}
