package cn.myspace.infrastructure.dao;

import cn.myspace.infrastructure.po.UserLike;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserLike)表数据库访问层
 */
@Mapper
public interface IUserLikeDao {

    /**
     * 查询数据是否存在
     *
     * @param userLike 实例对象
     * @return 行数
     */
    int isExist(UserLike userLike);

    /**
     * 新增数据
     *
     * @param userLike 实例对象
     * @return 影响行数
     */
    int insert(UserLike userLike);

    /**
     * 修改数据
     *
     * @param userLike 实例对象
     * @return 影响行数
     */
    int update(UserLike userLike);

}