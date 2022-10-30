package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.user.model.vo.RoleVO;
import cn.myspace.infrastructure.po.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleVOMapping extends IVOMapping<Role, RoleVO> {
    RoleVOMapping INSTANCE = Mappers.getMapper(RoleVOMapping.class);

    @Override
    RoleVO sourceToTarget(Role source);

    @Override
    List<RoleVO> sourceToTarget(List<Role> source);
}

