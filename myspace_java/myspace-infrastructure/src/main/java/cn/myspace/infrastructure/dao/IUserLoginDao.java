package cn.myspace.infrastructure.dao;

import cn.myspace.infrastructure.po.UserLogin;
import org.apache.ibatis.annotations.Mapper;

/**
 * (UserLogin)表数据库访问层
 */
@Mapper
public interface IUserLoginDao {

    /**
     * 通过ID查询单条数据
     *
     * @param infoId 主键
     * @return 实例对象
     */
    UserLogin queryById(Long infoId);

    /**
     * 新增数据
     *
     * @param userLogin 实例对象
     * @return 影响行数
     */
    int insert(UserLogin userLogin);

    /**
     * 修改数据
     *
     * @param userLogin 实例对象
     * @return 影响行数
     */
    int update(UserLogin userLogin);
}