package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.user.model.vo.UserCollectionVO;
import cn.myspace.infrastructure.po.UserCollection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserCollectionVOMapping extends IVOMapping<UserCollection, UserCollectionVO> {

    UserCollectionVOMapping INSTANCE = Mappers.getMapper(UserCollectionVOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "donor", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userToVO(source.getDonor()))"),
            @Mapping(target = "manuscript", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.manuscriptToVO(source.getManuscript()))"),
    })
    UserCollectionVO sourceToTarget(UserCollection source);

    @Override
    List<UserCollectionVO> sourceToTarget(List<UserCollection> source);
}
