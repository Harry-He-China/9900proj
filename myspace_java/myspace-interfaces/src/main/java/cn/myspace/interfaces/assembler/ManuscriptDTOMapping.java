package cn.myspace.interfaces.assembler;

import cn.myspace.domain.manuscript.model.vo.ManuscriptVO;
import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ManuscriptDTOMapping extends IDTOMapping<ManuscriptVO, ManuscriptDTO> {

    ManuscriptDTOMapping INSTANCE = Mappers.getMapper(ManuscriptDTOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "likeUserList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userListToDTO(source.getLikeUserList()))"),
            @Mapping(target = "dislikeUserList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userListToDTO(source.getDislikeUserList()))"),
            @Mapping(target = "favouriteUserList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userListToDTO(source.getFavouriteUserList()))"),
            @Mapping(target = "coinsUserList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userCoinsListToDTO(source.getCoinsUserList()))"),
            @Mapping(target = "rewardUserList", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.userRewardListToDTO(source.getRewardUserList()))"),
            @Mapping(target = "manuscriptComments", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.manuscriptCommentListToDTO(source.getManuscriptComments()))"),
            @Mapping(target = "goods", expression = "java(cn.myspace.interfaces.assembler.util.DTOTransformUtil.goodsListToDTO(source.getGoods()))"),
    })
    ManuscriptDTO sourceToTarget(ManuscriptVO source);

    @Override
    List<ManuscriptDTO> sourceToTarget(List<ManuscriptVO> source);
}
