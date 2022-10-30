package cn.myspace.rpc.goods.deploy;

import cn.myspace.rpc.goods.deploy.req.GoodsPageReq;
import cn.myspace.rpc.goods.deploy.res.GoodsRes;

/**
 * 商品部署服务接口
 */
public interface IGoodsDeploy {

    /**
     * 通过分页查询商品列表信息
     *
     * @param req   查询参数
     * @return      查询结果
     */
    GoodsRes queryGoodsListByPageForErp(GoodsPageReq req);
}
