package cn.myspace.infrastructure.dao;

import cn.myspace.infrastructure.po.GoodsComment;
import org.apache.ibatis.annotations.Mapper;

/**
 * (GoodsComment)表数据库访问层
 */
@Mapper
public interface IGoodsCommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    GoodsComment queryByIdWithChildComment(Long commentId);

    /**
     * 新增数据
     *
     * @param goodsComment 实例对象
     * @return 影响行数
     */
    int insert(GoodsComment goodsComment);

    /**
     * 修改数据
     *
     * @param goodsComment 实例对象
     * @return 影响行数
     */
    int update(GoodsComment goodsComment);

}