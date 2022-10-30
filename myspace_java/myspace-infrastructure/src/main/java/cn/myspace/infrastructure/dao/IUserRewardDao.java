package cn.myspace.infrastructure.dao;

import cn.myspace.infrastructure.po.UserReward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (UserReward)表数据库访问层
 */
@Mapper
public interface IUserRewardDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    List<UserReward> querySelfById(Long userId);

    /**
     * 通过ID查询单条数据
     *
     * @param donorId 主键
     * @return 实例对象
     */
    List<UserReward> queryDonorById(Long donorId);

    /**
     * 通过ID查询单条数据
     *
     * @param manuscriptId 主键
     * @return 实例对象
     */
    List<UserReward> queryManuscriptById(Long manuscriptId);

    /**
     * 新增数据
     *
     * @param userReward 实例对象
     * @return 影响行数
     */
    int insert(UserReward userReward);

    /**
     * 修改数据
     *
     * @param userReward 实例对象
     * @return 影响行数
     */
    int update(UserReward userReward);

}