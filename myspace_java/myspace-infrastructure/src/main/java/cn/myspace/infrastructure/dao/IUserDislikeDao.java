package cn.myspace.infrastructure.dao;

import cn.myspace.infrastructure.po.UserDislike;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserDislike)表数据库访问层
 */
@Mapper
public interface IUserDislikeDao {

    /**
     * 查询数据是否存在
     *
     * @param userDislike 实例对象
     * @return 行数
     */
    int isExist(UserDislike userDislike);

    /**
     * 新增数据
     *
     * @param userDislike 实例对象
     * @return 影响行数
     */
    int insert(UserDislike userDislike);

    /**
     * 修改数据
     *
     * @param userDislike 实例对象
     * @return 影响行数
     */
    int update(UserDislike userDislike);

}