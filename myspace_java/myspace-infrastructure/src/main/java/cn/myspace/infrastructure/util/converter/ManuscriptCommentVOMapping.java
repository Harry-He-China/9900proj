package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.manuscript.model.vo.ManuscriptCommentVO;
import cn.myspace.infrastructure.po.ManuscriptComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ManuscriptCommentVOMapping extends IVOMapping<ManuscriptComment, ManuscriptCommentVO> {

    ManuscriptCommentVOMapping INSTANCE = Mappers.getMapper(ManuscriptCommentVOMapping.class);

    @Override
    @Mappings({
        @Mapping(target = "comments", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.manuscriptCommentListToVO(source.getComments()))"),
    })
    ManuscriptCommentVO sourceToTarget(ManuscriptComment source);

    @Override
    List<ManuscriptCommentVO> sourceToTarget(List<ManuscriptComment> source);
}
