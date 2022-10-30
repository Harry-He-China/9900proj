package cn.myspace.interfaces.assembler;

import cn.myspace.domain.goods.model.vo.GoodsVO;
import cn.myspace.rpc.goods.deploy.dto.GoodsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface GoodsDTOMapping extends IDTOMapping<GoodsVO, GoodsDTO> {

    GoodsDTOMapping INSTANCE = Mappers.getMapper(GoodsDTOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "goodsComments", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.goodsCommentListToDTO(source.getGoodsComments()))"),
            @Mapping(target = "manuscripts", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.manuscriptListToDTO(source.getManuscripts()))"),
    })
    GoodsDTO sourceToTarget(GoodsVO source);

    @Override
    List<GoodsDTO> sourceToTarget(List<GoodsVO> source);
}
