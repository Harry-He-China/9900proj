package cn.myspace.interfaces.assembler;

import cn.myspace.domain.user.model.vo.UserLikeVO;
import cn.myspace.rpc.user.deploy.dto.UserLikeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserLikeDTOMapping extends IDTOMapping<UserLikeVO, UserLikeDTO> {

    UserLikeDTOMapping INSTANCE = Mappers.getMapper(UserLikeDTOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "donor", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userToDTO(source.getDonor()))"),
            @Mapping(target = "manuscript", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.manuscriptToDTO(source.getManuscript()))"),
    })
    UserLikeDTO sourceToTarget(UserLikeVO source);

    @Override
    List<UserLikeDTO> sourceToTarget(List<UserLikeVO> source);
}
