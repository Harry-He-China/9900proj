package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.user.model.vo.UserDislikeVO;
import cn.myspace.infrastructure.po.UserDislike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserDislikeVOMapping extends IVOMapping<UserDislike, UserDislikeVO> {

    UserDislikeVOMapping INSTANCE = Mappers.getMapper(UserDislikeVOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "donor", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userToVO(source.getDonor()))"),
            @Mapping(target = "manuscript", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.manuscriptToVO(source.getManuscript()))"),
    })
    UserDislikeVO sourceToTarget(UserDislike source);

    @Override
    List<UserDislikeVO> sourceToTarget(List<UserDislike> source);
}
