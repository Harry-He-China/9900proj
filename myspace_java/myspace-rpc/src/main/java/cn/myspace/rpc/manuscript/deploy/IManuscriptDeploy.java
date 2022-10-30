package cn.myspace.rpc.manuscript.deploy;

import cn.myspace.rpc.manuscript.deploy.req.ManuscriptPageReq;
import cn.myspace.rpc.manuscript.deploy.res.ManuscriptRes;

/**
 * 帖子部署服务接口
 */
public interface IManuscriptDeploy {

    /**
     * 通过分页查询帖子列表信息
     *
     * @param req   查询参数
     * @return      查询结果
     */
    ManuscriptRes queryManuscriptListByPageForErp(ManuscriptPageReq req);
}
