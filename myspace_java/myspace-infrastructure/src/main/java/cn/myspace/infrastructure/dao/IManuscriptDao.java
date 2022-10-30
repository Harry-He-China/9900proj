package cn.myspace.infrastructure.dao;

import cn.myspace.domain.manuscript.model.req.ManuscriptLimitPageReq;
import cn.myspace.infrastructure.po.Manuscript;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Manuscript)表数据库访问层
 */
@Mapper
public interface IManuscriptDao {

    /**
     * 通过ID查询单条数据
     *
     * @param manuscriptId 主键
     * @return 实例对象
     */
    Manuscript queryById(Long manuscriptId);

    /**
     * 通过ID查询单条数据
     *
     * @param manuscriptId 主键
     * @return 实例对象
     */
    Manuscript querySimpleById(Long manuscriptId);

    /**
     * 通过ID查询单条数据
     *
     * @param manuscriptId 主键
     * @return 实例对象
     */
    Manuscript queryLikeById(Long manuscriptId);

    /**
     * 通过ID查询单条数据
     *
     * @param manuscriptId 主键
     * @return 实例对象
     */
    Manuscript queryDislikeById(Long manuscriptId);

    /**
     * 通过ID查询单条数据
     *
     * @param manuscriptId 主键
     * @return 实例对象
     */
    Manuscript queryFavouriteById(Long manuscriptId);

    /**
     * 通过ID查询单条数据
     *
     * @param manuscriptId 主键
     * @return 实例对象
     */
    Manuscript queryCoinsById(Long manuscriptId);

    /**
     * 通过ID查询单条数据
     *
     * @param manuscriptId 主键
     * @return 实例对象
     */
    Manuscript queryRewardById(Long manuscriptId);

    /**
     * 通过实体作为筛选条件查询符合的数据条数
     *
     * @param manuscript 实例对象
     * @return 条数
     */
    long queryCount(@Param("m") ManuscriptLimitPageReq req);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param req 实例对象
     * @return 对象列表
     */
    List<Manuscript> queryAll(@Param("m") ManuscriptLimitPageReq req);

    /**
     * 新增数据
     *
     * @param manuscript 实例对象
     * @return 影响行数
     */
    int insert(Manuscript manuscript);

    /**
     * 修改数据
     *
     * @param manuscript 实例对象
     * @return 影响行数
     */
    int update(Manuscript manuscript);

}