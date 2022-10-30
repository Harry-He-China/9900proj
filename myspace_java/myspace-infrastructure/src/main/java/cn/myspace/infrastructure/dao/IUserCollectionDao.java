package cn.myspace.infrastructure.dao;

import cn.myspace.infrastructure.po.UserCollection;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserCollection)表数据库访问层
 */
@Mapper
public interface IUserCollectionDao {

    /**
     * 查询数据是否存在
     *
     * @param userCollection 实例对象
     * @return 行数
     */
    int isExist(UserCollection userCollection);

    /**
     * 新增数据
     *
     * @param userCollection 实例对象
     * @return 影响行数
     */
    int insert(UserCollection userCollection);

    /**
     * 修改数据
     *
     * @param userCollection 实例对象
     * @return 影响行数
     */
    int update(UserCollection userCollection);

}