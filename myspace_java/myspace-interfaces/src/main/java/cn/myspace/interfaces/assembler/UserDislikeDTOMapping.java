package cn.myspace.interfaces.assembler;

import cn.myspace.domain.user.model.vo.UserDislikeVO;
import cn.myspace.rpc.user.deploy.dto.UserDislikeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserDislikeDTOMapping extends IDTOMapping<UserDislikeVO, UserDislikeDTO> {

    UserDislikeDTOMapping INSTANCE = Mappers.getMapper(UserDislikeDTOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "donor", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userToDTO(source.getDonor()))"),
            @Mapping(target = "manuscript", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.manuscriptToDTO(source.getManuscript()))"),
    })
    UserDislikeDTO sourceToTarget(UserDislikeVO source);

    @Override
    List<UserDislikeDTO> sourceToTarget(List<UserDislikeVO> source);
}
