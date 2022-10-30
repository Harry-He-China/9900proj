package cn.myspace.interfaces.assembler;

import cn.myspace.domain.user.model.vo.UserLoginVO;
import cn.myspace.rpc.user.deploy.dto.UserLoginDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserLoginDTOMapping extends IDTOMapping<UserLoginVO, UserLoginDTO> {

    UserLoginDTOMapping INSTANCE = Mappers.getMapper(UserLoginDTOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "user", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userToDTO(source.getUser()))"),
    })
    UserLoginDTO sourceToTarget(UserLoginVO source);

    @Override
    List<UserLoginDTO> sourceToTarget(List<UserLoginVO> source);
}