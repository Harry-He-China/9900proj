package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.goods.model.vo.GoodsVO;
import cn.myspace.infrastructure.po.Goods;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface GoodsVOMapping extends IVOMapping<Goods, GoodsVO> {

    GoodsVOMapping INSTANCE = Mappers.getMapper(GoodsVOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "goodsComments", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.goodsCommentListToVO(source.getGoodsComments()))"),
            @Mapping(target = "manuscripts", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.manuscriptListToVO(source.getManuscripts()))"),
    })
    GoodsVO sourceToTarget(Goods source);

    @Override
    List<GoodsVO> sourceToTarget(List<Goods> source);
}
