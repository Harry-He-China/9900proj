package cn.myspace.interfaces.assembler;

import cn.myspace.domain.user.model.vo.UserInfoVO;
import cn.myspace.rpc.user.deploy.dto.UserInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserInfoDTOMapping extends IDTOMapping<UserInfoVO, UserInfoDTO> {

    UserInfoDTOMapping INSTANCE = Mappers.getMapper(UserInfoDTOMapping.class);

    @Override
    UserInfoDTO sourceToTarget(UserInfoVO source);

    @Override
    List<UserInfoDTO> sourceToTarget(List<UserInfoVO> source);
}
