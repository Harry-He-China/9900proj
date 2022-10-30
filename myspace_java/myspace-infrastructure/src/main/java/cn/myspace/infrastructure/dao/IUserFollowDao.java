package cn.myspace.infrastructure.dao;

import cn.myspace.infrastructure.po.UserFollow;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserFollow)表数据库访问层
 */
@Mapper
public interface IUserFollowDao {

    /**
     * 新增数据
     *
     * @param userFollow 实例对象
     * @return 影响行数
     */
    int insert(UserFollow userFollow);

    /**
     * 修改数据
     *
     * @param userFollow 实例对象
     * @return 影响行数
     */
    int update(UserFollow userFollow);

}