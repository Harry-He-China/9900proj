package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.user.model.vo.UserLikeVO;
import cn.myspace.infrastructure.po.UserLike;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserLikeVOMapping extends IVOMapping<UserLike, UserLikeVO> {

    UserLikeVOMapping INSTANCE = Mappers.getMapper(UserLikeVOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "donor", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userToVO(source.getDonor()))"),
            @Mapping(target = "manuscript", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.manuscriptToVO(source.getManuscript()))"),
    })
    UserLikeVO sourceToTarget(UserLike source);

    @Override
    List<UserLikeVO> sourceToTarget(List<UserLike> source);
}
