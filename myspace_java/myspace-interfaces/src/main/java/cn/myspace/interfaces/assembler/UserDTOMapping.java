package cn.myspace.interfaces.assembler;

import cn.myspace.domain.user.model.vo.UserVO;
import cn.myspace.rpc.user.deploy.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户DTO对象转换配置
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserDTOMapping extends IDTOMapping<UserVO, UserDTO> {

    UserDTOMapping INSTANCE = Mappers.getMapper(UserDTOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "info", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userInfoToDTO(source.getInfo()))"),
            @Mapping(target = "role", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.roleToDTO(source.getRole()))"),
            @Mapping(target = "followerList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userListToDTO(source.getFollowerList()))"),
            @Mapping(target = "funsList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userListToDTO(source.getFunsList()))"),
            @Mapping(target = "selfRewardList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userRewardListToDTO(source.getSelfRewardList()))"),
            @Mapping(target = "rewardList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userRewardListToDTO(source.getRewardList()))"),
            @Mapping(target = "selfCoinsList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userCoinsListToDTO(source.getSelfCoinsList()))"),
            @Mapping(target = "coinsList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userCoinsListToDTO(source.getCoinsList()))"),
            @Mapping(target = "likeList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.manuscriptListToDTO(source.getLikeList()))"),
            @Mapping(target = "collectionList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.manuscriptListToDTO(source.getCollectionList()))")
    })
    UserDTO sourceToTarget(UserVO source);


    @Override
    List<UserDTO> sourceToTarget(List<UserVO> source);

}



