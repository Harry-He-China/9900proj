package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.goods.model.vo.RelatedGoodsVO;
import cn.myspace.infrastructure.po.RelatedGoods;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author HaoHao
 * Created on 2022-10-29.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RelatedGoodsVOMapping extends IVOMapping<RelatedGoods, RelatedGoodsVO> {

    RelatedGoodsVOMapping INSTANCE = Mappers.getMapper(RelatedGoodsVOMapping.class);

    @Override
    RelatedGoodsVO sourceToTarget(RelatedGoods source);

    @Override
    List<RelatedGoodsVO> sourceToTarget(List<RelatedGoods> source);
}
