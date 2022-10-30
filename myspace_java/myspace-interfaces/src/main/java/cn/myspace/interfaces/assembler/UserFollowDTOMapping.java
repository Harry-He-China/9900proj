package cn.myspace.interfaces.assembler;

import cn.myspace.domain.user.model.vo.UserFollowVO;
import cn.myspace.rpc.user.deploy.dto.UserFollowDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserFollowDTOMapping extends IDTOMapping<UserFollowVO, UserFollowDTO> {

    UserFollowDTOMapping INSTANCE = Mappers.getMapper(UserFollowDTOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "fun", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userToDTO(source.getFun()))"),
            @Mapping(target = "follower", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userToDTO(source.getFollower()))"),
    })
    UserFollowDTO sourceToTarget(UserFollowVO source);

    @Override
    List<UserFollowDTO> sourceToTarget(List<UserFollowVO> source);
}
