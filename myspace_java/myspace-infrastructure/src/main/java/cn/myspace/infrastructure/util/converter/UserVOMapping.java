package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.user.model.vo.UserVO;
import cn.myspace.infrastructure.po.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户VO对象转换配置
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserVOMapping extends IVOMapping<User, UserVO> {

    UserVOMapping INSTANCE = Mappers.getMapper(UserVOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "info", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userInfoToVO(source.getInfo()))"),
            @Mapping(target = "role", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.roleToVO(source.getRole()))"),
            @Mapping(target = "followerList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userListToVO(source.getFollowerList()))"),
            @Mapping(target = "funsList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userListToVO(source.getFunsList()))"),
            @Mapping(target = "selfRewardList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userRewardListToVO(source.getSelfRewardList()))"),
            @Mapping(target = "rewardList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userRewardListToVO(source.getRewardList()))"),
            @Mapping(target = "selfCoinsList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userCoinsListToVO(source.getSelfCoinsList()))"),
            @Mapping(target = "coinsList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userCoinsListToVO(source.getCoinsList()))"),
            @Mapping(target = "likeList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.manuscriptListToVO(source.getLikeList()))"),
            @Mapping(target = "collectionList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.manuscriptListToVO(source.getCollectionList()))")
    })
    UserVO sourceToTarget(User source);


    @Override
    List<UserVO> sourceToTarget(List<User> source);

}



