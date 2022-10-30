package cn.myspace.infrastructure.dao;

import cn.myspace.domain.goods.model.req.OrderLimitPageReq;
import cn.myspace.infrastructure.po.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Order)表数据库访问层
 */
@Mapper
public interface IOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderId 主键
     * @return 实例对象
     */
    Order queryById(Long orderId);

    /**
     * 通过实体作为筛选条件查询符合的数据条数
     *
     * @param o 实例对象
     * @return 条数
     */
    long queryCount(@Param("o") OrderLimitPageReq o);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param req 实例对象
     * @return 对象列表
     */
    List<Order> queryAll(@Param("o")OrderLimitPageReq req);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    int insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 影响行数
     */
    int update(Order order);

}