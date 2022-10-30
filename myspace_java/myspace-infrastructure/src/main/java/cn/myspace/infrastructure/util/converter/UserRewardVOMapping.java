package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.user.model.vo.UserRewardVO;
import cn.myspace.infrastructure.po.UserReward;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserRewardVOMapping extends IVOMapping<UserReward, UserRewardVO> {

    UserRewardVOMapping INSTANCE = Mappers.getMapper(UserRewardVOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "contributor", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userToVO(source.getContributor()))"),
            @Mapping(target = "donor", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userToVO(source.getDonor()))"),
            @Mapping(target = "manuscript", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.manuscriptToVO(source.getManuscript()))"),
    })
    UserRewardVO sourceToTarget(UserReward source);

    @Override
    List<UserRewardVO> sourceToTarget(List<UserReward> source);
}
