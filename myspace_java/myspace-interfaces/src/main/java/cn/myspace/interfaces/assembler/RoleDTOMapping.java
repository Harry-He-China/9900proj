package cn.myspace.interfaces.assembler;

import cn.myspace.domain.user.model.vo.RoleVO;
import cn.myspace.rpc.user.deploy.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleDTOMapping extends IDTOMapping<RoleVO, RoleDTO> {
    RoleDTOMapping INSTANCE = Mappers.getMapper(RoleDTOMapping.class);

    @Override
    RoleDTO sourceToTarget(RoleVO source);

    @Override
    List<RoleDTO> sourceToTarget(List<RoleVO> source);
}

