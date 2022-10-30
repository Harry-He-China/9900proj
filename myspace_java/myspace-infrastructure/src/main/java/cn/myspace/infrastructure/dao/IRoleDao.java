package cn.myspace.infrastructure.dao;

import cn.myspace.infrastructure.po.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色信息表(Role)表数据库访问层
 */
@Mapper
public interface IRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    Role queryById(Integer roleId);

    /**
     * 通过ID查询单条数据
     *
     * @param userId 用户Id
     * @return 实例对象
     */
    Role queryByUserId(Long userId);

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Role> queryAll();

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int update(Role role);

}