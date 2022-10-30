package cn.myspace.infrastructure.dao;

import cn.myspace.infrastructure.po.RelatedGoods;
import org.apache.ibatis.annotations.Mapper;

/**
 * (RelatedGoods)表数据库访问层
 */
@Mapper
public interface IRelatedGoodsDao {

    /**
     * 新增数据
     *
     * @param relatedGoods 实例对象
     * @return 影响行数
     */
    int insert(RelatedGoods relatedGoods);

    /**
     * 修改数据
     *
     * @param relatedGoods 实例对象
     * @return 影响行数
     */
    int update(RelatedGoods relatedGoods);

}