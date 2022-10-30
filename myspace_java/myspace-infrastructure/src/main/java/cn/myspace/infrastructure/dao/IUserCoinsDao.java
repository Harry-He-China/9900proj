package cn.myspace.infrastructure.dao;

import cn.myspace.infrastructure.po.UserCoins;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (UserCoins)表数据库访问层
 */
@Mapper
public interface IUserCoinsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    List<UserCoins> querySelfById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param donorId 主键
     * @return 实例对象
     */
    List<UserCoins> queryDonorById(Long donorId);

    /**
     * 通过ID查询单条数据
     *
     * @param manuscriptId 主键
     * @return 实例对象
     */
    List<UserCoins> queryManuscriptById(Long manuscriptId);

    /**
     * 新增数据
     *
     * @param userCoins 实例对象
     * @return 影响行数
     */
    int insert(UserCoins userCoins);

    /**
     * 修改数据
     *
     * @param userCoins 实例对象
     * @return 影响行数
     */
    int update(UserCoins userCoins);
}