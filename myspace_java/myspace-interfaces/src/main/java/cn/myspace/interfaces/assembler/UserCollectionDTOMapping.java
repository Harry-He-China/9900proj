package cn.myspace.interfaces.assembler;

import cn.myspace.domain.user.model.vo.UserCollectionVO;
import cn.myspace.rpc.user.deploy.dto.UserCollectionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserCollectionDTOMapping extends IDTOMapping<UserCollectionVO, UserCollectionDTO> {

    UserCollectionDTOMapping INSTANCE = Mappers.getMapper(UserCollectionDTOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "donor", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userToDTO(source.getDonor()))"),
            @Mapping(target = "manuscript", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.manuscriptToDTO(source.getManuscript()))"),
    })
    UserCollectionDTO sourceToTarget(UserCollectionVO source);

    @Override
    List<UserCollectionDTO> sourceToTarget(List<UserCollectionVO> source);
}
