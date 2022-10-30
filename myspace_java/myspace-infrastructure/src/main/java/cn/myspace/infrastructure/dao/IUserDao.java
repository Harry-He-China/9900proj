package cn.myspace.infrastructure.dao;

import cn.myspace.domain.user.model.req.UserLimitPageReq;
import cn.myspace.infrastructure.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表数据库访问层
 */
@Mapper
public interface IUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User querySimpleById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryFollowerById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryFunsById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User querySelfRewardById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryRewardById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User querySelfCoinsById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryCoinsById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryLikeById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryCollectionById(Long userId);

    /**
     * 通过实体作为筛选条件查询符合的数据条数
     *
     * @param user 实例对象
     * @return 条数
     */
    long queryCount(@Param("u") UserLimitPageReq user);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<User> queryAll(@Param("u") UserLimitPageReq user);

    /**
     * 查询数据是否存在
     *
     * @param name 名称
     * @return 行数
     */
    User queryUserByName(String name);

    /**
     * 查询数据是否存在
     *
     * @param user 实例对象
     * @return 行数
     */
    User queryUserByEmail(User user);

    /**
     * 查询数据是否存在
     *
     * @param user 实例对象
     * @return 行数
     */
    User queryUserByUsername(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);
}