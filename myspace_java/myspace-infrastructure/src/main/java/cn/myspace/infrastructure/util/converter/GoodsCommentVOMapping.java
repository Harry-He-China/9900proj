package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.goods.model.vo.GoodsCommentVO;
import cn.myspace.infrastructure.po.GoodsComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface GoodsCommentVOMapping extends IVOMapping<GoodsComment, GoodsCommentVO> {

    GoodsCommentVOMapping INSTANCE = Mappers.getMapper(GoodsCommentVOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "comments", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.goodsCommentListToVO(source.getComments()))"),
    })
    GoodsCommentVO sourceToTarget(GoodsComment source);

    @Override
    List<GoodsCommentVO> sourceToTarget(List<GoodsComment> source);
}
