package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.user.model.vo.UserLoginVO;
import cn.myspace.infrastructure.po.UserLogin;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserLoginVOMapping extends IVOMapping<UserLogin, UserLoginVO> {

    UserLoginVOMapping INSTANCE = Mappers.getMapper(UserLoginVOMapping.class);

    @Override
    UserLoginVO sourceToTarget(UserLogin source);

    @Override
    List<UserLoginVO> sourceToTarget(List<UserLogin> source);
}
