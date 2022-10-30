package cn.myspace.interfaces.assembler;

import cn.myspace.domain.goods.model.vo.GoodsCommentVO;
import cn.myspace.rpc.goods.deploy.dto.GoodsCommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface GoodsCommentDTOMapping extends IDTOMapping<GoodsCommentVO, GoodsCommentDTO> {

    GoodsCommentDTOMapping INSTANCE = Mappers.getMapper(GoodsCommentDTOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "comments", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.goodsCommentListToDTO(source.getComments()))"),
    })
    GoodsCommentDTO sourceToTarget(GoodsCommentVO source);

    @Override
    List<GoodsCommentDTO> sourceToTarget(List<GoodsCommentVO> source);
}
