package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.goods.model.vo.OrderVO;
import cn.myspace.infrastructure.po.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderVOMapping extends IVOMapping<Order, OrderVO> {

    OrderVOMapping INSTANCE = Mappers.getMapper(OrderVOMapping.class);

    @Override

    @Mappings({
            @Mapping(target = "goods", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.goodsToVO(source.getGoods()))"),
    })
    OrderVO sourceToTarget(Order source);

    @Override
    List<OrderVO> sourceToTarget(List<Order> source);
}
