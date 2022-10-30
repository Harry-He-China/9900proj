package cn.myspace.infrastructure.util.converter;

import cn.myspace.domain.manuscript.model.vo.ManuscriptVO;
import cn.myspace.infrastructure.po.Manuscript;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ManuscriptVOMapping extends IVOMapping<Manuscript, ManuscriptVO> {

    ManuscriptVOMapping INSTANCE = Mappers.getMapper(ManuscriptVOMapping.class);

    @Override
    @Mappings({
            @Mapping(target = "likeUserList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userListToVO(source.getLikeUserList()))"),
            @Mapping(target = "dislikeUserList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userListToVO(source.getDislikeUserList()))"),
            @Mapping(target = "favouriteUserList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userListToVO(source.getFavouriteUserList()))"),
            @Mapping(target = "coinsUserList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userCoinsListToVO(source.getCoinsUserList()))"),
            @Mapping(target = "rewardUserList", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.userRewardListToVO(source.getRewardUserList()))"),
            @Mapping(target = "manuscriptComments", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.manuscriptCommentListToVO(source.getManuscriptComments()))"),
            @Mapping(target = "goods", expression = "java(cn.myspace.infrastructure.util.VOTransformUtil.goodsListToVO(source.getGoods()))"),
    })
    ManuscriptVO sourceToTarget(Manuscript source);

    @Override
    List<ManuscriptVO> sourceToTarget(List<Manuscript> source);
}
