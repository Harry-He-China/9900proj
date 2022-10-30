package cn.myspace.infrastructure.util;

import cn.myspace.domain.goods.model.vo.GoodsCommentVO;
import cn.myspace.domain.goods.model.vo.GoodsVO;
import cn.myspace.domain.goods.model.vo.OrderVO;
import cn.myspace.domain.manuscript.model.vo.ManuscriptCommentVO;
import cn.myspace.domain.manuscript.model.vo.ManuscriptVO;
import cn.myspace.domain.user.model.vo.*;
import cn.myspace.infrastructure.po.*;
import cn.myspace.infrastructure.util.converter.*;

import java.util.List;

/**
 * VO对象转换工具
 */
public class VOTransformUtil {

    /* User */
    public static UserVO userToVO(User user){
        return UserVOMapping.INSTANCE.sourceToTarget(user);
    }

    public static List<UserVO> userListToVO(List<User> userList){
        return UserVOMapping.INSTANCE.sourceToTarget(userList);
    }

    public static UserInfoVO userInfoToVO(UserInfo userinfo){
        return UserInfoVOMapping.INSTANCE.sourceToTarget(userinfo);
    }

    public static RoleVO roleToVO(Role role){
        return RoleVOMapping.INSTANCE.sourceToTarget(role);
    }

    public static List<UserRewardVO> userRewardListToVO(List<UserReward> userRewardList){
        return UserRewardVOMapping.INSTANCE.sourceToTarget(userRewardList);
    }

    public static List<UserCoinsVO> userCoinsListToVO(List<UserCoins> userCoinsList){
        return UserCoinsVOMapping.INSTANCE.sourceToTarget(userCoinsList);
    }

    /* Manuscript */
    public static ManuscriptVO manuscriptToVO(Manuscript manuscript){
        return ManuscriptVOMapping.INSTANCE.sourceToTarget(manuscript);
    }

    public static List<ManuscriptVO> manuscriptListToVO(List<Manuscript> manuscriptList){
        return ManuscriptVOMapping.INSTANCE.sourceToTarget(manuscriptList);
    }

    public static ManuscriptCommentVO manuscriptCommentToVO(ManuscriptComment manuscriptComment){
        return ManuscriptCommentVOMapping.INSTANCE.sourceToTarget(manuscriptComment);
    }

    public static List<ManuscriptCommentVO> manuscriptCommentListToVO(List<ManuscriptComment> manuscriptCommentList){
        return ManuscriptCommentVOMapping.INSTANCE.sourceToTarget(manuscriptCommentList);
    }

    /* Goods */
    public static GoodsVO goodsToVO(Goods goods){
        return GoodsVOMapping.INSTANCE.sourceToTarget(goods);
    }

    public static List<GoodsVO> goodsListToVO(List<Goods> goodsList){
        return GoodsVOMapping.INSTANCE.sourceToTarget(goodsList);
    }

    public static GoodsCommentVO goodsCommentToVO(GoodsComment goodsComment){
        return GoodsCommentVOMapping.INSTANCE.sourceToTarget(goodsComment);
    }

    public static List<GoodsCommentVO> goodsCommentListToVO(List<GoodsComment> goodsCommentList){
        return GoodsCommentVOMapping.INSTANCE.sourceToTarget(goodsCommentList);
    }

    /* Order */
    public static OrderVO orderToVO(Order order){
        return OrderVOMapping.INSTANCE.sourceToTarget(order);
    }

    public static List<OrderVO> orderListToVO(List<Order> orderList){
        return OrderVOMapping.INSTANCE.sourceToTarget(orderList);
    }
}
