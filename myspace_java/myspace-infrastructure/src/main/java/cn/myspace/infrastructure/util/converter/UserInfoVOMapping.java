package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.user.model.vo.UserInfoVO;
import cn.myspace.infrastructure.po.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserInfoVOMapping extends IVOMapping<UserInfo, UserInfoVO> {

    UserInfoVOMapping INSTANCE = Mappers.getMapper(UserInfoVOMapping.class);

    @Override
    UserInfoVO sourceToTarget(UserInfo source);

    @Override
    List<UserInfoVO> sourceToTarget(List<UserInfo> source);
}
