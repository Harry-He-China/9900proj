package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.user.model.vo.UserFollowVO;
import cn.myspace.infrastructure.po.UserFollow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserFollowVOMapping extends IVOMapping<UserFollow, UserFollowVO> {

    UserFollowVOMapping INSTANCE = Mappers.getMapper(UserFollowVOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "fun", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userToVO(source.getFun()))"),
            @Mapping(target = "follower", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userToVO(source.getFollower()))"),
    })
    UserFollowVO sourceToTarget(UserFollow source);

    @Override
    List<UserFollowVO> sourceToTarget(List<UserFollow> source);
}
