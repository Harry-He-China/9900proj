package cn.myspace.interfaces.assembler;

import cn.myspace.domain.goods.model.vo.OrderVO;
import cn.myspace.rpc.goods.deploy.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface OrderDTOMapping extends IDTOMapping<OrderVO, OrderDTO> {

    OrderDTOMapping INSTANCE = Mappers.getMapper(OrderDTOMapping.class);

    @Override

    @Mappings({
            @Mapping(target = "goods", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.goodsToDTO(source.getGoods()))"),
    })
    OrderDTO sourceToTarget(OrderVO source);

    @Override
    List<OrderDTO> sourceToTarget(List<OrderVO> source);
}
