package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.user.model.vo.UserCoinsVO;
import cn.myspace.infrastructure.po.UserCoins;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserCoinsVOMapping extends IVOMapping<UserCoins, UserCoinsVO> {

    UserCoinsVOMapping INSTANCE = Mappers.getMapper(UserCoinsVOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "contributor", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userToVO(source.getContributor()))"),
            @Mapping(target = "donor", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userToVO(source.getDonor()))"),
            @Mapping(target = "manuscript", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.manuscriptToVO(source.getManuscript()))"),
    })
    UserCoinsVO sourceToTarget(UserCoins source);

    @Override
    List<UserCoinsVO> sourceToTarget(List<UserCoins> source);
}
