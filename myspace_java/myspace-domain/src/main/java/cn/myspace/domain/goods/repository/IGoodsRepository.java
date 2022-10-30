package cn.myspace.domain.goods.repository;

import cn.myspace.domain.goods.model.req.GoodsLimitPageReq;
import cn.myspace.domain.goods.model.res.GoodsLimitPageRes;
import cn.myspace.domain.goods.model.vo.GoodsCommentVO;
import cn.myspace.domain.goods.model.vo.GoodsVO;
import cn.myspace.domain.goods.model.vo.RelatedGoodsVO;

/**
 * 商品资源库
 */
public interface IGoodsRepository {

    /* Goods */

    GoodsLimitPageRes queryGoodsLimitPage(GoodsLimitPageReq req);

    GoodsVO queryGoodsById(Long goodsId);

    GoodsVO queryGoodsByIdWithComment(Long goodsId);

    GoodsVO queryGoodsByIdWithManuscript(Long goodsId);

    int insertGoods(GoodsVO goodsVO);

    int updateGoods(GoodsVO goodsVO);

    int deleteGoods(GoodsVO goodsVO);

    /* GoodsComment */

    GoodsCommentVO queryGoodsCommentByIdWithChildComment(Long commentId);

    int insertGoodsComment(GoodsCommentVO goodsCommentVO);

    int updateGoodsComment(GoodsCommentVO goodsCommentVO);

    int deleteGoodsComment(GoodsCommentVO goodsCommentVO);

    /* RelatedGoods */

    int insertRelatedGoods(RelatedGoodsVO relatedGoodsVO);

    int updateRelatedGoods(RelatedGoodsVO relatedGoodsVO);

    int deleteRelatedGoods(RelatedGoodsVO relatedGoodsVO);
}
