package cn.myspace.interfaces.assembler;

import cn.myspace.domain.user.model.vo.UserCoinsVO;
import cn.myspace.rpc.user.deploy.dto.UserCoinsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserCoinsDTOMapping extends IDTOMapping<UserCoinsVO, UserCoinsDTO> {

    UserCoinsDTOMapping INSTANCE = Mappers.getMapper(UserCoinsDTOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "contributor", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userToDTO(source.getContributor()))"),
            @Mapping(target = "donor", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userToDTO(source.getDonor()))"),
            @Mapping(target = "manuscript", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.manuscriptToDTO(source.getManuscript()))"),
    })
    UserCoinsDTO sourceToTarget(UserCoinsVO source);

    @Override
    List<UserCoinsDTO> sourceToTarget(List<UserCoinsVO> source);
}
