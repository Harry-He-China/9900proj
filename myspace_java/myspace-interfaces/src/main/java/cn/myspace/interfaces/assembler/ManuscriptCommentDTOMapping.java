package cn.myspace.interfaces.assembler;

import cn.myspace.domain.manuscript.model.vo.ManuscriptCommentVO;
import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptCommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ManuscriptCommentDTOMapping extends IDTOMapping<ManuscriptCommentVO, ManuscriptCommentDTO> {

    ManuscriptCommentDTOMapping INSTANCE = Mappers.getMapper(ManuscriptCommentDTOMapping.class);

    @Override
    @Mappings({
        @Mapping(target = "comments", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.manuscriptCommentListToDTO(source.getComments()))"),
    })
    ManuscriptCommentDTO sourceToTarget(ManuscriptCommentVO source);

    @Override
    List<ManuscriptCommentDTO> sourceToTarget(List<ManuscriptCommentVO> source);
}
