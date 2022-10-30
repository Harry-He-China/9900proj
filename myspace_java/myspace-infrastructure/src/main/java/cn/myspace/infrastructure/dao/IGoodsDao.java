package cn.myspace.infrastructure.dao;

import cn.myspace.domain.goods.model.req.GoodsLimitPageReq;
import cn.myspace.infrastructure.po.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Goods)表数据库访问层
 */
@Mapper
public interface IGoodsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    Goods queryById(Long goodsId);

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    Goods queryByIdWithComment(Long goodsId);

    /**
     * 通过ID查询单条数据
     *
     * @param goodsId 主键
     * @return 实例对象
     */
    Goods queryByIdWithManuscript(Long goodsId);

    /**
     * 通过实体作为筛选条件查询符合的数据条数
     *
     * @param goods 实例对象
     * @return 条数
     */
    long queryCount(@Param("g") GoodsLimitPageReq goods);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param req 实例对象
     * @return 对象列表
     */
    List<Goods> queryAll(@Param("g") GoodsLimitPageReq req);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int insert(Goods goods);

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int update(Goods goods);

}