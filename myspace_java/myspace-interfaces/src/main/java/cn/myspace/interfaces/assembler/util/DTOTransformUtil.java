package cn.myspace.interfaces.assembler.util;

import cn.myspace.domain.goods.model.vo.GoodsCommentVO;
import cn.myspace.domain.goods.model.vo.GoodsVO;
import cn.myspace.domain.goods.model.vo.OrderVO;
import cn.myspace.domain.manuscript.model.vo.ManuscriptCommentVO;
import cn.myspace.domain.manuscript.model.vo.ManuscriptVO;
import cn.myspace.domain.user.model.vo.*;
import cn.myspace.interfaces.assembler.*;
import cn.myspace.rpc.goods.deploy.dto.GoodsCommentDTO;
import cn.myspace.rpc.goods.deploy.dto.GoodsDTO;
import cn.myspace.rpc.goods.deploy.dto.OrderDTO;
import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptCommentDTO;
import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptDTO;
import cn.myspace.rpc.user.deploy.dto.*;

import java.util.List;

/**
 */
public class DTOTransformUtil {

    /* User */
    public static UserDTO userToDTO(UserVO user){
        return UserDTOMapping.INSTANCE.sourceToTarget(user);
    }

    public static List<UserDTO> userListToDTO(List<UserVO> userList){
        return UserDTOMapping.INSTANCE.sourceToTarget(userList);
    }

    public static UserInfoDTO userInfoToDTO(UserInfoVO userinfo){
        return UserInfoDTOMapping.INSTANCE.sourceToTarget(userinfo);
    }

    public static RoleDTO roleToDTO(RoleVO role){
        return RoleDTOMapping.INSTANCE.sourceToTarget(role);
    }

    public static List<UserRewardDTO> userRewardListToDTO(List<UserRewardVO> userRewardList){
        return UserRewardDTOMapping.INSTANCE.sourceToTarget(userRewardList);
    }

    public static List<UserCoinsDTO> userCoinsListToDTO(List<UserCoinsVO> userCoinsList){
        return UserCoinsDTOMapping.INSTANCE.sourceToTarget(userCoinsList);
    }

    /* Manuscript */
    public static ManuscriptDTO manuscriptToDTO(ManuscriptVO manuscript){
        return ManuscriptDTOMapping.INSTANCE.sourceToTarget(manuscript);
    }

    public static List<ManuscriptDTO> manuscriptListToDTO(List<ManuscriptVO> manuscriptList){
        return ManuscriptDTOMapping.INSTANCE.sourceToTarget(manuscriptList);
    }

    public static ManuscriptCommentDTO manuscriptCommentToDTO(ManuscriptCommentVO manuscriptComment){
        return ManuscriptCommentDTOMapping.INSTANCE.sourceToTarget(manuscriptComment);
    }

    public static List<ManuscriptCommentDTO> manuscriptCommentListToDTO(List<ManuscriptCommentVO> manuscriptCommentList){
        return ManuscriptCommentDTOMapping.INSTANCE.sourceToTarget(manuscriptCommentList);
    }

    /* Goods */
    public static GoodsDTO goodsToDTO(GoodsVO goods){
        return GoodsDTOMapping.INSTANCE.sourceToTarget(goods);
    }

    public static List<GoodsDTO> goodsListToDTO(List<GoodsVO> goodsList){
        return GoodsDTOMapping.INSTANCE.sourceToTarget(goodsList);
    }

    public static GoodsCommentDTO goodsCommentToDTO(GoodsCommentVO goodsComment){
        return GoodsCommentDTOMapping.INSTANCE.sourceToTarget(goodsComment);
    }

    public static List<GoodsCommentDTO> goodsCommentListToDTO(List<GoodsCommentVO> goodsCommentList){
        return GoodsCommentDTOMapping.INSTANCE.sourceToTarget(goodsCommentList);
    }

    /* Order */
    public static OrderDTO orderToDTO(OrderVO order){
        return OrderDTOMapping.INSTANCE.sourceToTarget(order);
    }

    public static List<OrderDTO> orderListToDTO(List<OrderVO> orderList){
        return OrderDTOMapping.INSTANCE.sourceToTarget(orderList);
    }
}
